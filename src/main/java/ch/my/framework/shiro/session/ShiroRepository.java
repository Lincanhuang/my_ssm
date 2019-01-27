package ch.my.framework.shiro.session;

import java.util.Collection;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.util.Destroyable;
import org.apache.shiro.util.Initializable;

public interface ShiroRepository extends CacheManager, Initializable, Destroyable {

	void save(Session session);

	void delete(Session session);

	Collection<Session> getActiveSessions();

}
