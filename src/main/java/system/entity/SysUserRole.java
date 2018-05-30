package system.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import framework.entity.AbstractEntity;

@Entity
@Table(name = "sys_user_role")
public class SysUserRole extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8580611450685901340L;
	@Id
	private Long userId;
	@Id
	private Long roleId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
}
