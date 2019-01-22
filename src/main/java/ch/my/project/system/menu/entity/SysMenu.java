package ch.my.project.system.menu.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ch.my.framework.entity.AbstractEntity;
import ch.my.framework.entity.MenuTypeEnum;
import ch.my.project.system.role.entity.SysRole;

@Entity
@Table(name = "sys_menu")
public class SysMenu extends AbstractEntity {
	private static final long serialVersionUID = -6772808760391805675L;
	
	 /** 菜单名称 */
    private String menuName;
	 
    /** 显示顺序 */
    private String orderNum;
    
    /** 菜单URL */
    private String url;
    
    /** 类型:0目录,1菜单,2按钮 */
    @Enumerated(EnumType.ORDINAL)
    private MenuTypeEnum menuType = MenuTypeEnum.MENU;
    
    /** 菜单状态:显示,隐藏 */
    private boolean visible = true;
    
    /** 权限字符串 */
    private String perms;
    
    /** 菜单图标 */
    private String icon;
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.PERSIST},fetch=FetchType.LAZY)
	@JoinColumn(name="parentId")
	private SysMenu parent;
    @OneToMany(cascade= {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.LAZY)
    @JoinColumn(name="parentId")
	Set<SysMenu> children;
	
    @ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "sys_role_resource",
          joinColumns = {@JoinColumn(name = "resourceId")},
          inverseJoinColumns = {@JoinColumn(name = "roleId")})
	private Set<SysRole> sysRoles = new LinkedHashSet<>();
    public SysMenu() {
		super();
	}
	public SysMenu(String menuName) {
		super();
		setMenuName(menuName);
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public MenuTypeEnum getMenuType() {
		return menuType;
	}
	public void setMenuType(MenuTypeEnum menuType) {
		this.menuType = menuType;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public String getPerms() {
		return perms;
	}
	public void setPerms(String perms) {
		this.perms = perms;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public SysMenu getParent() {
		return parent;
	}
	public void setParent(SysMenu parent) {
		this.parent = parent;
	}
	public Set<SysMenu> getChildren() {
		return children;
	}
	public void setChildren(Set<SysMenu> children) {
		this.children = children;
	}
	public Set<SysRole> getSysRoles() {
		return sysRoles;
	}
	public void setSysRoles(Set<SysRole> sysRoles) {
		this.sysRoles = sysRoles;
	}
	
}
