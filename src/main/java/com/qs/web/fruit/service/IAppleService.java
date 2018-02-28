package com.qs.web.fruit.service;

import org.springframework.stereotype.Service;

import com.qs.web.fruit.dto.AppleDto;
@Service
public interface IAppleService {
	
	public AppleDto getApple(Integer id);
	
	public void insertApple();

}
