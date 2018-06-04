package system.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import system.entity.SysResource;
import system.entity.SysRole;
@Repository
public interface SysResourceRepository  extends JpaRepository<SysResource, Long>{
	
	public List<SysResource> findBySysRoles_IdIn(Collection<Long> roleIds);
	
	public List<SysResource> findBySysRolesIn(Collection<SysRole> roles);
	
	public List<SysResource> findBySysRoles_Id(Long roleId);
	
	public List<SysResource> findBySysRoles(SysResource roleId);
}