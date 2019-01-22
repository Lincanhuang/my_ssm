package ch.my.project.system.user.repository;

import org.springframework.stereotype.Repository;

import ch.my.common.repository.CommonRepository;
import ch.my.project.system.user.entity.SysUser;
@Repository
public interface SysUserRepository  extends CommonRepository<SysUser, Long>{
	public SysUser findByUsername(String username);
}