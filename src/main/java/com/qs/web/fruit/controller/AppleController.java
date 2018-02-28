package com.qs.web.fruit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qs.web.fruit.dto.AppleDto;
import com.qs.web.fruit.service.IAppleService;

@Controller
public class AppleController {
	@Autowired
	private IAppleService appleService;

	/* 该注解用于将Controller的方法返回的对象，通过适当的HttpMessageConverter转换为指定格式后，写入到Response对象的body数据区。*/
	@ResponseBody
	@RequestMapping(value="apple/selectApple.do",method=RequestMethod.GET)
	public String selectApple(HttpServletRequest request,HttpServletResponse response) {

		AppleDto appleDto = appleService.getApple(1);
		
		System.out.println("appleName======="+appleDto.getName());
		return null;
	}
	
}
