package com.qs.web.fruit.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.qs.web.fruit.dao.IUserDao;
import com.qs.web.fruit.dto.UserDto;
import com.qs.web.fruit.service.IUserService;
@Service
public class UserServiceImpl implements IUserService{
	@Resource
	private IUserDao userDao;
	
	@Override
	public Boolean loginCheck(String loginName, String password) {
	
		Subject currentUser=SecurityUtils.getSubject();
		
		String pass=this.userDao.getPasswordById(loginName);
		if (pass.equals(password)) {
			if (!currentUser.isAuthenticated()) {
				UsernamePasswordToken token=new UsernamePasswordToken(loginName,password);
				token.setRememberMe(false);
				currentUser.login(token);
			}			
			return true;
		}else{
			return false;
		}	
	}

	@Override
	public void addUsers() {
		List<UserDto> userDtos = new ArrayList<UserDto>();
		UserDto user=new UserDto();
		user.setLoginName("admin01");
		user.setPassword("1234");
		user.setTelephone("15885226322");
		user.setUserName("也门");
		userDtos.add(user);
		
		UserDto user1=new UserDto();
		user.setLoginName("admin02");
		user.setPassword("1234");
		user.setTelephone("15896332566");
		user.setUserName("沙特阿拉伯");
		userDtos.add(user1);
		
		UserDto user2=new UserDto();
		user.setLoginName("admin03");
		user.setPassword("1234");
		user.setTelephone("15896332566");
		user.setUserName("奔上");
		userDtos.add(user2);
	this.userDao.addUsers(userDtos);	
	}

	@Override
	public void getUserById() {
		
		System.out.println("here you are!!");
		
	}
}
