package ch.my.framework.shiro.session.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.authz.AuthorizationFilter;

public class KitLogin extends AuthorizationFilter {

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}
