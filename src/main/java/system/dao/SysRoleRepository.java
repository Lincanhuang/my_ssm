package system.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import system.entity.SysRole;
import system.entity.SysUser;
@Repository
public interface SysRoleRepository  extends JpaRepository<SysRole, Long>{
	
	public List<SysRole> findBySysUsersIdIn(Collection<Long> sysUserIds);
	
	public List<SysRole> findBySysUsersIn(Collection<SysUser> sysUsers);
	
	public List<SysRole> findBySysUsers(SysUser sysUser);
	
	public List<SysRole> findBySysUsersId(Long sysUserId);
}