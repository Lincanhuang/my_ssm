package system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import system.dao.SysResourceRepository;
import system.dao.SysRoleRepository;
import system.entity.SysMenu;
import system.entity.SysRole;

@Service
public class SysMenuService {
	@Autowired
	private SysResourceRepository sysResourceRepository;
	
	@Autowired
	private SysRoleRepository sysRoleRepository;
	
	public SysMenu save(SysMenu resource) {
		resource = sysResourceRepository.save(resource);
		return resource;
	}
	@Transactional(readOnly = false)
	public void delete(SysMenu resource) {
		sysResourceRepository.deleteById(resource.getId());
	}
	
	@Transactional(readOnly = false)
	public SysMenu getById(Long id)
	{
		SysMenu one = sysResourceRepository.getOne(id);
		return one;
	}
	public List<SysMenu> listByUserId(Long userId) {
		List<SysRole> roles = sysRoleRepository.findBySysUsersId(userId);
		return sysResourceRepository.findBySysRolesIn(roles);
	}
	public List<SysMenu> listByParentId(Long parentId) {
		List<SysMenu> roles = sysResourceRepository.findByParent_Id(parentId);
		return roles;
	}
}
