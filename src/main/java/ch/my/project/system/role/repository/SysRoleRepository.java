package ch.my.project.system.role.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import ch.my.common.repository.CommonRepository;
import ch.my.project.system.role.entity.SysRole;
import ch.my.project.system.user.entity.SysUser;
@Repository
public interface SysRoleRepository  extends CommonRepository<SysRole, Long>{
	
	public List<SysRole> findBySysUsersIdIn(Collection<Long> sysUserIds);
	
	public List<SysRole> findBySysUsersIn(Collection<SysUser> sysUsers);
	
	public List<SysRole> findBySysUsers(SysUser sysUser);
	
	public List<SysRole> findBySysUsersId(Long sysUserId);
}