/**
 * Project Name:SpringOA
 * File Name:User.java
 * Package Name:com.zml.oa.entity
 * Date:2014-11-8下午11:12:48
 *
 */
package system.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @ClassName: User
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: zml
 * @date: 2014-11-8 下午11:12:48
 *
 */

@Entity
@Table(name = "T_USER")
public class User implements Serializable{

	private static final long serialVersionUID = -6662232329895785824L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	private String name;
	
	private String passwd;
	
	private String salt; // 加密密码的盐
	
	@Temporal(TemporalType.DATE)
	private Date registerDate;
	
    private Boolean locked;
	
	//bi-directional many-to-many association to Group
//    @ManyToMany
//    @JoinTable(name = "T_MEMBERSHIP", joinColumns = {@JoinColumn(name = "USER_ID")}, inverseJoinColumns = {@JoinColumn(name = "GROUP_ID")})
//    private List<Group> group;

	//多对一，@JoinColumn与@column类似，指定映射的数据库字段
	@ManyToOne(targetEntity = Group.class)
//	@JoinColumn(name="id")
	@JsonIgnore
    private Group group;
    
	public User(){
		
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public Date getRegisterDate() {
		return registerDate;
	}


	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Group getGroup() {
		return group;
	}


	public void setGroup(Group group) {
		this.group = group;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}
	
    public String getCredentialsSalt() {
        return name + salt;
    }

}
