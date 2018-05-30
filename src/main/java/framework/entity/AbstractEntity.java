package framework.entity;

import java.io.Serializable;
import java.util.Date;

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

	/**
	 * 
	 */
	private static final long serialVersionUID = -4403201098478415153L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date createDate = new Date();
	
	private Date updateDate = new Date();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "AbstractEntity [getId()=" + getId() + ", getCreateDate()=" + getCreateDate() + ", getUpdateDate()="
				+ getUpdateDate() + "]";
	}

}
