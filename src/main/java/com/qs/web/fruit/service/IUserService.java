package com.qs.web.fruit.service;

import org.springframework.stereotype.Service;


@Service
public interface IUserService {
	
	public Boolean loginCheck(String loginName,String passworld);
	public void addUsers();
	public void getUserById();
}
