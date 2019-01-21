package system.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import common.dao.CommonRepository;
import system.entity.SysMenu;
import system.entity.SysRole;
@Repository
public interface SysResourceRepository  extends CommonRepository<SysMenu, Long>{
	
	public List<SysMenu> findBySysRoles_IdIn(Collection<Long> roleIds);
	
	public List<SysMenu> findBySysRolesIn(Collection<SysRole> roles);
	
	public List<SysMenu> findBySysRoles_Id(Long roleId);
	
	public List<SysMenu> findBySysRoles(SysMenu sysMenu);
	
	public List<SysMenu> findByParent_Id(Long parentId);
}