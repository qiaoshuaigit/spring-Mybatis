package com.qs.web.fruit.dao;

import com.qs.web.fruit.dto.AppleDto;

public interface IAppleDao {
	
	public AppleDto getAppleById(Integer id);
	
	public void insertAppleInfo(AppleDto appleInfo);

}
