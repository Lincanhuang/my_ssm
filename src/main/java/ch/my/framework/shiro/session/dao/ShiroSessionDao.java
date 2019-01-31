package ch.my.framework.shiro.session.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import javax.cache.Cache;
import javax.cache.Cache.Entry;
import javax.cache.CacheManager;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;

public class ShiroSessionDao implements SessionDAO {

	private SessionIdGenerator sessionIdGenerator;

	private CacheManager cacheManager;

	// private RedisClient redisClient;

	private Cache<Serializable, Session> activeSessions;

	private String activeSessionsCacheName = "shiro-activeSessionCache";

	public ShiroSessionDao() {
		this.sessionIdGenerator = new JavaUuidSessionIdGenerator();
	}

	public SessionIdGenerator getSessionIdGenerator() {
		return sessionIdGenerator;
	}

	public void setSessionIdGenerator(SessionIdGenerator sessionIdGenerator) {
		this.sessionIdGenerator = sessionIdGenerator;
	}

	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	public CacheManager getCacheManager() {
		return cacheManager;
	}

	public String getActiveSessionsCacheName() {
		return activeSessionsCacheName;
	}

	public void setActiveSessionsCacheName(String activeSessionsCacheName) {
		this.activeSessionsCacheName = activeSessionsCacheName;
	}

	public Cache<Serializable, Session> getActiveSessionsCache() {
		return this.activeSessions;
	}

	public void setActiveSessionsCache(Cache<Serializable, Session> cache) {
		this.activeSessions = cache;
	}

	private Cache<Serializable, Session> getActiveSessionsCacheLazy() {
		if (this.activeSessions == null) {
			this.activeSessions = createActiveSessionsCache();
		}
		return activeSessions;
	}

	protected Cache<Serializable, Session> createActiveSessionsCache() {
		CacheManager mgr = getCacheManager();
		String name = getActiveSessionsCacheName();
		if (mgr == null) {
			throw new IllegalArgumentException("CacheManager cannot be null ");
		}
		return mgr.getCache(name);
	}

	@Override
	public Serializable create(Session session) {
		Serializable sessionId = generateSessionId(session);
		((SimpleSession) session).setId(sessionId);
		if (sessionId == null) {
			String msg = "sessionId returned from doCreate implementation is null.  Please verify the implementation.";
			throw new IllegalStateException(msg);
		}
		storeSession(session, sessionId);
		return sessionId;
	}

	@Override
	public Session readSession(Serializable sessionId) throws UnknownSessionException {
		Session s = null;
		if (sessionId != null) {
			Cache<Serializable, Session> cache = getActiveSessionsCacheLazy();
			if (cache != null) {
				s = cache.get(sessionId);
			}
		}
		if (s == null) {
			throw new UnknownSessionException("There is no session with id [" + sessionId + "]");
		}
		return s;
	}

	@Override
	public void update(Session session) throws UnknownSessionException {
		if (session instanceof ValidatingSession) {
			if (((ValidatingSession) session).isValid()) {
				storeSession(session, session.getId());
			} else {
				delete(session);
			}
		} else {
			storeSession(session, session.getId());
		}
	}

	@Override
	public void delete(Session session) {
		if (session == null) {
			return;
		}
		Serializable id = session.getId();
		if (id == null) {
			return;
		}
		Cache<Serializable, Session> cache = getActiveSessionsCacheLazy();
		if (cache != null) {
			cache.remove(id);
		}
	}

	@Override
	public Collection<Session> getActiveSessions() {
		Collection<Session> s = Collections.emptySet();
		Cache<Serializable, Session> cache = getActiveSessionsCacheLazy();
		Iterator<Entry<Serializable, Session>> iterator = cache.iterator();

		for (; iterator.hasNext();) {
			Entry<Serializable, Session> en = iterator.next();
			System.out.println(en.getKey());

		}
		iterator.forEachRemaining((c) -> {
			s.add(c.getValue());
		});
		return s;
	}

	protected void storeSession(Session session, Serializable sessionId) {
		if (session == null || sessionId == null) {
			return;
		}
		Cache<Serializable, Session> cache = getActiveSessionsCacheLazy();
		if (cache == null) {
			return;
		}
		cache.put(sessionId, session);
	}

	protected Serializable generateSessionId(Session session) {
		if (this.sessionIdGenerator == null) {
			String msg = "sessionIdGenerator attribute has not been configured.";
			throw new IllegalStateException(msg);
		}
		return this.sessionIdGenerator.generateId(session);
	}

}
