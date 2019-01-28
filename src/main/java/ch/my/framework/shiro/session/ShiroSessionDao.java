package ch.my.framework.shiro.session;

import java.io.Serializable;

import org.apache.shiro.cache.AbstractCacheManager;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.my.framework.shiro.cache.ShiroCache;

public class ShiroSessionDao extends CachingSessionDAO {
	
    private static final Logger log = LoggerFactory.getLogger(ShiroSessionDao.class);
	
	public ShiroSessionDao() {
		setCacheManager(new AbstractCacheManager() {
            @Override
            protected Cache<Serializable, Session> createCache(String name) throws CacheException {
                return new ShiroCache<Serializable, Session>(name);
            }
        });
    }
	
	public Serializable doCreate(Session session) {
		Serializable sessionId = generateSessionId(session);
		assignSessionId(session, sessionId);
		return sessionId;
	}

	@Override
	protected void doUpdate(Session session) {
		if(getCacheManager() == null) {
			log.debug("shiroRepository is null");
			return;
		}
		Cache<Serializable, Session> createActiveSessionsCache = createActiveSessionsCache();
		if(createActiveSessionsCache.get(session.getId()) == null) {
			createActiveSessionsCache.put(session.getId(), session);
		}
	}

	@Override
	protected void doDelete(Session session) {
	}

	@Override
	public Session doReadSession(Serializable sessionId) {
		return createActiveSessionsCache().get(sessionId);
	}
	

}
