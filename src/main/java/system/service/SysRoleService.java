package system.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import system.dao.SysRoleRepository;
import system.entity.SysRole;

@Service
public class SysRoleService {
	@Resource
	public SysRoleRepository sysRoleRepository;
	@Cacheable(value="cameraCache")
	public List<SysRole> listRolesByUserId(Long userId) {
		return sysRoleRepository.findBySysUsersId(userId);
	}

}
