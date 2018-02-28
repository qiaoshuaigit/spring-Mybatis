package com.qs.web.fruit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qs.web.fruit.dao.IAppleDao;
import com.qs.web.fruit.dto.AppleDto;
import com.qs.web.fruit.service.IAppleService;
@Transactional
@Service
public class AppleServiceImpl implements IAppleService{
	
	@Autowired
	public IAppleDao appleDao;
	
	@Override
	public AppleDto getApple(Integer id) {
		AppleDto appleDto = appleDao.getAppleById(1);
		return appleDto;
	}

	@Override
	public void insertApple() {
		AppleDto appleDto = new AppleDto();
		appleDto.setId(92);
		appleDto.setSale("123");
		appleDto.setCustomerId(281);
		appleDto.setName("44444444");
		appleDto.setRank("31");
		appleDto.setField("2200");
		
		appleDao.insertAppleInfo(appleDto);
		
		AppleDto appleDto1 = new AppleDto();
		appleDto1.setId(22);
		appleDto1.setSale("555");
		appleDto1.setCustomerId(26);
		appleDto1.setName("888888888");
		appleDto1.setRank("2551");
		appleDto1.setField("2552");
		appleDto1.setCreateDate("2015-02-25");
		
		appleDao.insertAppleInfo(appleDto1);

		
	}

}
