package ch.my.project.system.role.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import ch.my.project.system.role.entity.SysRole;
import ch.my.project.system.role.repository.SysRoleRepository;

@Service
public class SysRoleService {
	@Resource
	public SysRoleRepository sysRoleRepository;
	
	@Cacheable(value="cameraCache")
	public List<SysRole> listRolesByUserId(Long userId) {
		return sysRoleRepository.findBySysUsersId(userId);
	}
	
	@Cacheable(value="cameraCache")
	public List<SysRole> listAll() {
		return sysRoleRepository.findAll();
	}

}
