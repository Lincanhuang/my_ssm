package ch.my.framework.shiro.session.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Spliterator;

import javax.cache.Cache;
import javax.cache.Cache.Entry;
import javax.cache.CacheManager;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;

public class ShiroSessionDao extends AbstractSessionDAO  {

	public static final String ACTIVE_SESSION_CACHE_NAME = "shiro-activeSessionCache";

	private CacheManager cacheManager;

	private Cache<Serializable, Session> activeSessions;

	private String activeSessionsCacheName = ACTIVE_SESSION_CACHE_NAME;

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
		Cache<Serializable, Session> cache = null;
		CacheManager mgr = getCacheManager();
		String name = getActiveSessionsCacheName();
		if (mgr != null) {
			cache = mgr.getCache(name);
		}
		if (mgr == null) {
//			setCacheManager(new MemoryConstrainedCacheManager());
//			cache = getCacheManager().getCache(name);
		}
		return cache;
	}

	@Override
	public Serializable create(Session session) {
		Serializable sessionId = super.create(session);
		storeSession(session, sessionId);
		return sessionId;
	}

	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = generateSessionId(session);
		assignSessionId(session, sessionId);
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
			s = super.readSession(sessionId);
		}
		return s;
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		return getActiveSessionsCacheLazy().get(sessionId);
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
		iterator.forEachRemaining((c)->{
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

}
