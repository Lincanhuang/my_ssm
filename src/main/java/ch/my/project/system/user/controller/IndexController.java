package ch.my.project.system.user.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.my.framework.entity.MenuTypeEnum;
import ch.my.project.system.menu.entity.SysMenu;
import ch.my.project.system.menu.service.SysMenuService;

@Controller
@RequestMapping(value = "admin")
public class IndexController {
	
	@Resource
	private SysMenuService sysMenuService;

	@RequestMapping(value = {"","index"})
	public String index(HttpServletRequest request, Model model) {
		String str = "";
		DefaultWebSecurityManager dwsm = new DefaultWebSecurityManager();
//		dwsm.setSubjectDAO(subjectDAO);
//		str = null;
//		System.out.println(str.length());
		List<SysMenu> menus = sysMenuService.listByMenuType(MenuTypeEnum.BUTTON);
		model.addAttribute("menus", menus);
		return "admin/index";
	}
	@RequestMapping(value = {"test"})
	@RequiresRoles("test")
	@ResponseBody
	public String test(HttpServletRequest request) {
		SecurityUtils.getSubject().getPrincipal();
		return "{dsgdas}";
	}
	@RequestMapping(value = {"per"})
	@RequiresPermissions("per")
	public String per(HttpServletRequest request) {
		SecurityUtils.getSubject().getPrincipal();
		return "admin/index";
	}
}
