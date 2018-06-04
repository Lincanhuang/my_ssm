package system.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import system.dao.SysRoleRepository;
import system.entity.SysRole;

@Service
public class SysRoleService {
	@Resource
	public SysRoleRepository sysRoleRepository;
	public List<SysRole> listRolesByUserId(Long userId) {
//		sysRoleRepository
		return null;
	}

}
