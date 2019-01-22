package ch.my.project.system.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.my.project.system.menu.entity.SysMenu;
import ch.my.project.system.menu.repository.SysMenuRepository;
import ch.my.project.system.role.entity.SysRole;
import ch.my.project.system.role.repository.SysRoleRepository;

@Service
public class SysMenuService {
	@Autowired
	private SysMenuRepository sysMenuRepository;
	
	@Autowired
	private SysRoleRepository sysRoleRepository;
	
	public SysMenu save(SysMenu resource) {
		resource = sysMenuRepository.save(resource);
		return resource;
	}
	@Transactional(readOnly = false)
	public void delete(SysMenu resource) {
		sysMenuRepository.deleteById(resource.getId());
	}
	public void deleteById(Long id) {
		sysMenuRepository.deleteById(id);
	}
	
	public SysMenu getById(Long id)
	{
		SysMenu one = sysMenuRepository.getOne(id);
		return one;
	}
	public List<SysMenu> listByUserId(Long userId) {
		List<SysRole> roles = sysRoleRepository.findBySysUsersId(userId);
		return sysMenuRepository.findBySysRolesIn(roles);
	}
	public List<SysMenu> listByParentId(Long parentId) {
		List<SysMenu> roles = sysMenuRepository.findByParent_Id(parentId);
		return roles;
	}
}
