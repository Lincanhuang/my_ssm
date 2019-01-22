package ch.my.project.system.menu.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import ch.my.common.repository.CommonRepository;
import ch.my.project.system.menu.entity.SysMenu;
import ch.my.project.system.role.entity.SysRole;
@Repository
public interface SysMenuRepository  extends CommonRepository<SysMenu, Long>{
	
	public List<SysMenu> findBySysRoles_IdIn(Collection<Long> roleIds);
	
	public List<SysMenu> findBySysRolesIn(Collection<SysRole> roles);
	
	public List<SysMenu> findBySysRoles_Id(Long roleId);
	
	public List<SysMenu> findBySysRoles(SysMenu sysMenu);
	
	public List<SysMenu> findByParent_Id(Long parentId);

	public  List<SysMenu> findBySysRoles_SysUsers_Username(String username);

	public List<SysMenu> findBySysRoles_SysUsers_Id(long sysUserId);
}