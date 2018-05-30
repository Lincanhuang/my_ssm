package system.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import framework.entity.AbstractEntity;

@Entity
@Table(name = "sys_role")
public class SysRole extends AbstractEntity {
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 622242870755257735L;
	
	private String name;
    
	private String description;
    
	private Boolean available;
	
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "sys_user_role",
          joinColumns = {@JoinColumn(name = "roleId")},
          inverseJoinColumns = {@JoinColumn(name = "userId")})
	private Set<SysUser> roles = new LinkedHashSet<>();

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

}
