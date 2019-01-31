package ch.my.project.system.role.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.my.project.system.role.entity.SysRole;
import ch.my.project.system.role.service.SysRoleService;

@Controller
@RequestMapping("role")
@RequiresRoles("admin")
public class RoleController {

	@Resource
	private SysRoleService sysRoleService;
	
	@GetMapping("list")
	@ResponseBody
	@RequiresAuthentication
	public List<SysRole> listRoles(HttpServletRequest request){
		return sysRoleService.listAll();
	}
}
