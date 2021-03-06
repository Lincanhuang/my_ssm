package ch.my.framework.shiro.realm;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import ch.my.framework.entity.UserStatusEnum;
import ch.my.project.system.menu.entity.SysMenu;
import ch.my.project.system.menu.service.SysMenuService;
import ch.my.project.system.role.entity.SysRole;
import ch.my.project.system.role.service.SysRoleService;
import ch.my.project.system.user.entity.SysUser;
import ch.my.project.system.user.service.SysUserService;

public class ShiroRealm extends AuthorizingRealm {

	@Resource
	private SysUserService sysUserService;
	@Resource
	private SysMenuService sysMenuService;
	@Resource
	private SysRoleService sysRoleService;

	/**
	 * 提供账户信息返回认证信息（用户的角色信息集合）
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 获取用户的输入的账号.
		String username = token.getPrincipal().toString();
		SysUser user = sysUserService.getByUserName(username);
		if (user == null) {
			throw new UnknownAccountException("账号不存在！");
		}
		if (UserStatusEnum.DISABLE.equals(user.getUserStatus())) {
			throw new LockedAccountException("帐号已被锁定，禁止登录！");
		}

		// principal参数使用用户Id，方便动态刷新用户权限
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getId(), user.getPassword(),ByteSource.Util.bytes(user.getSalt()), getName());
		return simpleAuthenticationInfo;
	}

	/**
	 * 权限认证，为当前登录的Subject授予角色和权限（角色的权限信息集合）
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		 if (principals == null) {
	        throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
        }
		Long userId = (Long) getAvailablePrincipal(principals);
		// 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//		userId = (Long) SecurityUtils.getSubject().getPrincipal();
		// 赋予角色
		List<SysRole> roleList = sysRoleService.listRolesByUserId(userId);
		if (!CollectionUtils.isEmpty(roleList)) {
			roleList.stream().forEach((t) -> {
				info.addRole(t.getName());
			});
		}

		// 赋予权限
		List<SysMenu> resourcesList = sysMenuService.listByUserId(userId);
		if (!CollectionUtils.isEmpty(resourcesList)) {
			resourcesList.stream().forEach((t) -> {
				String permission = t.getPerms();
				if (!StringUtils.isEmpty(permission)) {
					info.addStringPermission(permission);
				}
			});
		}
		return info;
	}
}
