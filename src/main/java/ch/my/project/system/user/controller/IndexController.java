package ch.my.project.system.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "admin")
public class IndexController {

	@RequestMapping(value = {"","index"})
	public String index(HttpServletRequest request) {
		SecurityUtils.getSubject().getPrincipal();
		return "admin/index";
	}
	@RequestMapping(value = {"test"})
	@RequiresRoles("test")
	public String test(HttpServletRequest request) {
		SecurityUtils.getSubject().getPrincipal();
		return "admin/index";
	}
	@RequestMapping(value = {"per"})
	@RequiresPermissions("per")
	public String per(HttpServletRequest request) {
		SecurityUtils.getSubject().getPrincipal();
		return "admin/index";
	}
}
