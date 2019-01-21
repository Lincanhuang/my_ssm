package system.entity;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import framework.entity.AbstractEntity;
import framework.entity.UserStatusEnum;

@Entity
@Table(name = "sys_user")
public class SysUser extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 868924786965358341L;
	/**
     * 登陆名称.
     */
	@Column(nullable = false, unique = true)
	@NotEmpty
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	
	@Enumerated(EnumType.ORDINAL)
	private UserStatusEnum UserStatus = UserStatusEnum.ENABLE;
	private String salt;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "sys_user_role",
          joinColumns = {@JoinColumn(name = "userId")},
          inverseJoinColumns = {@JoinColumn(name = "roleId")})
	private Set<SysRole> roles = new LinkedHashSet<>();//多角色
	
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Set<SysRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<SysRole> roles) {
		this.roles = roles;
	}

	public UserStatusEnum getUserStatus() {
		return UserStatus;
	}

	public void setUserStatus(UserStatusEnum userStatus) {
		UserStatus = userStatus;
	}

	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
}
