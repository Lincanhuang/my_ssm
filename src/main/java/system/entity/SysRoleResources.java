package system.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import framework.entity.AbstractEntity;

@Entity
@Table(name = "sys_role_resource")
public class SysRoleResources extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3422940411071950259L;
	private Long roleId;
	private Long resourcesId;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getResourcesId() {
		return resourcesId;
	}

	public void setResourcesId(Long resourcesId) {
		this.resourcesId = resourcesId;
	}

}
