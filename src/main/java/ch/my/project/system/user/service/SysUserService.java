package ch.my.project.system.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ch.my.project.system.user.entity.SysUser;
import ch.my.project.system.user.repository.SysUserRepository;

@Service
public class SysUserService {
	@Resource
	private SysUserRepository sysUserRepository;
	public SysUser getByUserName(String username) {
		return sysUserRepository.findByUsername(username);
	}

}
