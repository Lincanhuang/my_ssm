package system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import system.dao.SysResourceRepository;
import system.dao.SysRoleRepository;
import system.entity.SysResource;
import system.entity.SysRole;

@Service
public class SysResourceService {
	@Autowired
	private SysResourceRepository sysResourceRepository;
	
	@Autowired
	private SysRoleRepository sysRoleRepository;
	
	public SysResource save(SysResource resource) {
		resource = sysResourceRepository.save(resource);
		return resource;
	}
	@Transactional(readOnly = false)
	public void delete(SysResource resource) {
		sysResourceRepository.deleteById(resource.getId());
	}
	
	@Transactional(readOnly = false)
	public SysResource getById(Long id)
	{
		SysResource one = sysResourceRepository.getOne(id);
		return one;
	}
	public List<SysResource> listByUserId(Long userId) {
		List<SysRole> roles = sysRoleRepository.findBySysUsersId(userId);
		return sysResourceRepository.findBySysRolesIn(roles);
	}
}
