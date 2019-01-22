package ch.my.framework.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 
 * @author lchhey
 *
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	private static final long serialVersionUID = -4403201098478415153L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	/**
	 * 添加用户（当前用户）.
	 */
	@Column(length = 50, nullable = false)
	protected String createdUser;
	/**
	 * 添加时间（当前时间）.
	 */
	@Column(nullable = false)
	protected Date createdDate;
	/**
	 * 添加IP（当前客户端IP）.
	 */
	@Column(length = 100)
	protected String createdIp;
	/**
	 * 修改用户（当前用户）.
	 */
	@Column(length = 50)
	protected String lastModifiedUser;
	/**
	 * 修改时间（当前时间）.
	 */
	protected Date lastModifiedDate;
	/**
	 * 修改IP（当前客户端IP）.
	 */
	@Column(length = 100)
	protected String lastModifiedIp;

	public Long getId() {
	    return id;
	}

	public void setId(Long id) {
	    this.id = id;
	}

	public String getCreatedUser() {
	    return createdUser;
	}

	public void setCreatedUser(String createdUser) {
	    this.createdUser = createdUser;
	}

	public Date getCreatedDate() {
	    return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
	    this.createdDate = createdDate;
	}

	public String getCreatedIp() {
	    return createdIp;
	}

	public void setCreatedIp(String createdIp) {
	    this.createdIp = createdIp;
	}

	public String getLastModifiedUser() {
	    return lastModifiedUser;
	}

	public void setLastModifiedUser(String lastModifiedUser) {
	    this.lastModifiedUser = lastModifiedUser;
	}

	public Date getLastModifiedDate() {
	    return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
	    this.lastModifiedDate = lastModifiedDate;
	}

	public String getLastModifiedIp() {
	    return lastModifiedIp;
	}

	public void setLastModifiedIp(String lastModifiedIp) {
	    this.lastModifiedIp = lastModifiedIp;
	}

	@Override
	public String toString() {
		Class<? extends AbstractEntity> t = this.getClass();
		return t.getSimpleName() + "[id = " + id + "]";
	}

}

