package com.qs.web.fruit.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.qs.web.fruit.dao.IAppleDao;
import com.qs.web.fruit.dto.AppleDto;
@Repository
public class AppleDaoImpl extends SqlSessionDaoSupport  implements IAppleDao{
	
	@Override
	public AppleDto getAppleById(Integer id) {
		AppleDto appleDto = (AppleDto) this.getSqlSession().selectOne("com.qs.web.fruit.dao.IAppleDao.getAppleById", id);
		return appleDto;
	}

	@Override
	public void insertAppleInfo(AppleDto appleInfo) {
		//System.out.println(this.getSqlSession() instanceof SqlSessionTemplate);//结果 ture
		this.getSqlSession().insert("com.qs.web.fruit.dao.IAppleDao.insertAppleInfo", appleInfo);
	}

}
