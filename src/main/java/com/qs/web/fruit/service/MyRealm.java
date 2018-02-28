package com.qs.web.fruit.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.qs.web.fruit.dao.IUserDao;
import com.qs.web.fruit.dto.PrivilegeDto;
import com.qs.web.fruit.dto.UserDto;

public class MyRealm extends AuthorizingRealm {
	
	@Resource(name="userDao")
	private IUserDao userDao;

	/**
	 * 登陆身份验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken userToken=(UsernamePasswordToken)token;
		if (userToken.getUsername()==null&&"".equals(userToken.getUsername())) {
			throw new AccountException("用户名不能为空!");
		}
		List<UserDto> users = this.userDao.getUserByLoginName(userToken.getUsername());
		if (users.isEmpty()) {
			throw new UnknownAccountException("No account found for user [" + userToken.getUsername() + "]");
		} else if (new String(userToken.getPassword()).equals(users.get(0).getPassword())) {
			return new SimpleAuthenticationInfo(users.get(0).getLoginName(), users.get(0).getPassword(), getName());
		} else {
			throw new AuthenticationException("AuthenticationException");
		}
	}
	/**
	 * 授权验证
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		if (principals == null) {
			throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
		}
		String loginName=(String) principals.fromRealm(getName()).iterator().next();
		List<UserDto> users = this.userDao.getUserByLoginName(loginName);
		if (users.isEmpty()) {
			return null;
		}
		List<PrivilegeDto>  privilegeDtos= this.userDao.getPrivilegeByUserId(users.get(0).getId());
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		for (PrivilegeDto privilege:privilegeDtos) {
			info.addStringPermission(privilege.getPrivilegeId().toString());
		}	
		return info;
	}
	

}
