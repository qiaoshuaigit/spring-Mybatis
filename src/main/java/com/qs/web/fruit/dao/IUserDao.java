package com.qs.web.fruit.dao;

import java.util.List;

import com.qs.web.fruit.dto.PrivilegeDto;
import com.qs.web.fruit.dto.UserDto;

public interface IUserDao {
	
	public String getPasswordById(String loginName);
	public List<UserDto> getUserByLoginName(String loginName);
	public List<PrivilegeDto> getPrivilegeByUserId(Integer userId);
	public void addUsers(List<UserDto> userDtos);

}
