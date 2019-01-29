package ch.my.framework.shiro.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionFactory;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.web.session.mgt.DefaultWebSessionContext;
import org.apache.shiro.web.session.mgt.WebSessionContext;

public class ShiroSessionFactory implements SessionFactory {
	/**
     * Creates a new {@link SimpleSession SimpleSession} instance retaining the context's
     * {@link SessionContext#getHost() host} if one can be found.
     *
     * @param initData the initialization data to be used during {@link Session} creation.
     * @return a new {@link SimpleSession SimpleSession} instance
     */
    public Session createSession(SessionContext initData) {
        if (initData != null) {
        	if (initData instanceof WebSessionContext) {
        		((WebSessionContext) initData).getServletRequest();
        	}
        	
            String host = initData.getHost();
            if (host != null) {
                return new SimpleSession(host);
            }
        }
        return new SimpleSession();
    }
}
