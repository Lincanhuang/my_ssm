package ch.my.project.system.role.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ch.my.framework.entity.AbstractEntity;
import ch.my.project.system.menu.entity.SysMenu;
import ch.my.project.system.user.entity.SysUser;

@Entity
@Table(name = "sys_role")
public class SysRole extends AbstractEntity {
   
	private static final long serialVersionUID = 622242870755257735L;
	
	private String name;
    
	private String description;
    
	private Boolean available;
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "sys_user_role",
          joinColumns = {@JoinColumn(name = "roleId")},
          inverseJoinColumns = {@JoinColumn(name = "userId")})
	private Set<SysUser> sysUsers = new LinkedHashSet<>();
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "sys_role_menu",
          joinColumns = {@JoinColumn(name = "roleId")},
          inverseJoinColumns = {@JoinColumn(name = "menuId")})
	private Set<SysMenu> sysMenus = new LinkedHashSet<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public Set<SysUser> getSysUsers() {
		return sysUsers;
	}

	public void setSysUsers(Set<SysUser> sysUsers) {
		this.sysUsers = sysUsers;
	}

	public Set<SysMenu> getSysMenus() {
		return sysMenus;
	}

	public void setSysResources(Set<SysMenu> sysMenus) {
		this.sysMenus = sysMenus;
	}
	
}
