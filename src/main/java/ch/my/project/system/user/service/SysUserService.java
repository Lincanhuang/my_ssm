package ch.my.project.system.user.service;

import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
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
//	@Transactional
	public SysUser save(SysUser user) {
		return sysUserRepository.save(user);
	}
	
	public final String getHexPwd(String orginPwd, String salt) {
		SimpleHash simpleHash = new SimpleHash("SHA-256", orginPwd, salt, 2);
		return simpleHash.toHex();
	}
	
	public final void enUserHexPwd(SysUser user) {
		String salt = creatSalt();
		user.setSalt(salt);
		SimpleHash simpleHash = new SimpleHash("SHA-256", user.getPassword(), user.getSalt(), 2);
		user.setPassword(simpleHash.toHex());
	}
	
	private String creatSalt() {
		ThreadLocalRandom currentRandom = ThreadLocalRandom.current();
		byte[] bytes = new byte[4];
		currentRandom.nextBytes(bytes);
		ByteSource byteSource = ByteSource.Util.bytes(bytes);
		return byteSource.toHex();
	}
}
