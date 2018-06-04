package system.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import framework.entity.AbstractEntity;

@Entity
@Table(name = "sys_resource")
public class SysResource extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6772808760391805675L;
	
	private String name;
	private String type;
	private String url;
	private String permission;
	
	private Integer sort;
	private Boolean external;
	private Boolean available;
	private String icon;
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.EAGER)
	@JoinColumn(name="parentId")
	private SysResource parent;
    @OneToMany(cascade= {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.EAGER)
    @JoinColumn(name="parentId")
	Set<SysResource> children;
	
    @ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "sys_role_resource",
          joinColumns = {@JoinColumn(name = "resourceId")},
          inverseJoinColumns = {@JoinColumn(name = "roleId")})
	private Set<SysRole> sysRoles = new LinkedHashSet<>();
    public SysResource() {
		super();
	}
	public SysResource(String name) {
		super();
		setName(name);
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Boolean getExternal() {
		return external;
	}

	public void setExternal(Boolean external) {
		this.external = external;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public SysResource getParent() {
		return parent;
	}

	public void setParent(SysResource parent) {
		this.parent = parent;
	}
	
	public Set<SysResource> getChildren() {  
	        return children;  
	}
	
	public void setChildren(Set<SysResource> children) {
		this.children = children;
	}
	
	public Long getParentId() {
		if(parent == null)
			return null;
		return parent.getId();
	}

}
