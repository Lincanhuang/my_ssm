package ch.my.framework.shiro.session;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.session.mgt.SimpleSessionFactory;
import org.apache.shiro.web.session.mgt.WebSessionContext;

public class ShiroSessionFactory extends SimpleSessionFactory {
	@Override
	public Session createSession(SessionContext initData) {
		SimpleSession simpleSession = new SimpleSession();
		 if (initData != null) {
	            String host = initData.getHost();
	            if (host != null) {
	            	simpleSession.setHost(host);
	            }
	            if(initData instanceof WebSessionContext) {
	            	WebSessionContext sessionContext = (WebSessionContext) initData;
//	            	RequestContextHolder.getRequestAttributes().
	    			HttpServletRequest request = (HttpServletRequest) sessionContext.getServletRequest();
	    			request.getHeader("User-Agent");
	    			if (request != null) {
	    				String uerAgent = request.getHeader("User-Agent");
	    				System.out.println(uerAgent);
//	    				UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
	    				// 获取客户端操作系统
//	    				String os = userAgent.getOperatingSystem().getName();
//	    				// 获取客户端浏览器
//	    				String browser = userAgent.getBrowser().getName();
//	    				session.setHost(IpUtils.getIpAddr(request));
//	    				session.setBrowser(browser);
//	    				session.setOs(os);
	    			}
	            }
		 }
		 return simpleSession;
	}
}
