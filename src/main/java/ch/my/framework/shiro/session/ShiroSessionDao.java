package ch.my.framework.shiro.session;

import java.io.Serializable;
import java.util.Collection;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShiroSessionDao extends CachingSessionDAO {
	
    private static final Logger log = LoggerFactory.getLogger(ShiroSessionDao.class);
	
	private ShiroRepository shiroRepository;
	
	public Serializable doCreate(Session session) {
		Serializable sessionId = generateSessionId(session);
		assignSessionId(session, sessionId);
		return sessionId;
	}

	@Override
	protected void doUpdate(Session session) {
		if(shiroRepository == null) {
			log.debug("shiroRepository is null");
			return;
		}
		shiroRepository.save(session);
		
	}

	@Override
	protected void doDelete(Session session) {
		if(shiroRepository == null) {
			super.delete(session);
			return;
		}
        shiroRepository.delete(session);
	}

	@Override
	public Session doReadSession(Serializable sessionId) {
		if(shiroRepository == null) {
			log.debug("shiroRepository is null");
			return null;
		}
		return null;
	}
	
	@Override
	 public Collection<Session> getActiveSessions() {
		if(shiroRepository == null) {
			return super.getActiveSessions();
		} else {
			return shiroRepository.getActiveSessions();
		}
    }


}
