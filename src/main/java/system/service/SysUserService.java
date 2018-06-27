package system.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import system.dao.SysUserRepository;
import system.entity.SysUser;

@Service
public class SysUserService {
	@Resource
	private SysUserRepository sysUserRepository;
	public SysUser getByUserName(String username) {
		return sysUserRepository.findByUsername(username);
	}

}
