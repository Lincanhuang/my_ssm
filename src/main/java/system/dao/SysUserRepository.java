package system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import system.entity.SysUser;
@Repository
public interface SysUserRepository  extends JpaRepository<SysUser, Long>{
	public SysUser findByUsername(String username);
}