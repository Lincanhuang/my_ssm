package ch.my.project.system.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ch.my.project.system.menu.entity.SysMenu;
import ch.my.project.system.menu.repository.SysMenuRepository;

@Service
public class SysMenuService {
	@Autowired
	private SysMenuRepository sysMenuRepository;
	
	public SysMenu save(SysMenu resource) {
		resource = sysMenuRepository.save(resource);
		return resource;
	}
	public void delete(SysMenu resource) {
		sysMenuRepository.deleteById(resource.getId());
	}
	public void deleteById(Long id) {
		sysMenuRepository.deleteById(id);
	}
	public SysMenu getById(Long id) {
		return sysMenuRepository.findById(id).orElse(null);
	}
	
	public List<SysMenu> listByParentId(Long parentId) {
		List<SysMenu> roles = sysMenuRepository.findByParent_Id(parentId);
		return roles;
	}
	
	public List<SysMenu> listByUserId(long userId) {
		List<SysMenu> menus = sysMenuRepository.findBySysRoles_SysUsers_Id(userId);
		return menus;
	}
	
	public List<SysMenu> listByUserName(String username) {
		List<SysMenu> menus = sysMenuRepository.findBySysRoles_SysUsers_Username(username);
		return menus;
	}
	public Page<SysMenu> pageList(Pageable page) {
		Page<SysMenu> menus = sysMenuRepository.findAll(page);
		return menus;
	}
}
