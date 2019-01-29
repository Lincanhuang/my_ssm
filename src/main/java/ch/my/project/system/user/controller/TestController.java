package ch.my.project.system.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "")
public class TestController {

	@RequestMapping(value = {"test","index"})
	public String index(HttpServletRequest request) {
//		SecurityUtils.getSubject().getPrincipal();
		return "admin/index";
	}
	@RequestMapping(value = {"json"})
	@RequiresRoles("test")
	@ResponseBody
	public String test(HttpServletRequest request) {
//		SecurityUtils.getSubject().getPrincipal();
		return "{dsgdas}";
	}
	@RequestMapping(value = {"per"})
	@RequiresPermissions("per")
	public String per(HttpServletRequest request) {
//		SecurityUtils.getSubject().getPrincipal();
		return "admin/index";
	}
}
