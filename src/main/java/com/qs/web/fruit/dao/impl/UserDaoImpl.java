package com.qs.web.fruit.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.qs.web.fruit.dao.IUserDao;
import com.qs.web.fruit.dto.PrivilegeDto;
import com.qs.web.fruit.dto.UserDto;
@Repository
public class UserDaoImpl implements IUserDao{
	
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public String getPasswordById(String loginName) {
		sqlSessionTemplate.selectOne("com.qs.web.fruit.dao.IUserDao.getPasswordById", loginName);
		return null;
	}

	@Override
	public List<UserDto> getUserByLoginName(String loginName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PrivilegeDto> getPrivilegeByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUsers(List<UserDto> userDtos) {
		// TODO Auto-generated method stub
		
	}

}
