package com.qs.web.fruit.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qs.web.fruit.service.IUserService;
@Controller
public class LoginController {
	
	private Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@ExceptionHandler(Exception.class)
	public String throwException(Exception e){
		log.error(e.getMessage());
		return "exception";
	}
	
	
	@Resource
	private IUserService userService;
	
	@RequestMapping(value="login.do",method =RequestMethod.POST)
	public String loginCheck(HttpSession session,HttpServletResponse response,@Param("loginName")String loginName,@Param("password")String password) {
		
		
		if (loginName==null||"".equals(loginName)) {
			return "login";
		}
		if (this.userService.loginCheck(loginName, password)) {
			/*PrintWriter out=null;
		    response.setCharacterEncoding("utf-8");       
		    //response.setContentType("text/html; charset=utf-8"); 
			try {
			   out = response.getWriter();
				out.print("你爷爷的！！！");
				out.close();
			} catch (IOException e) {				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/	
			this.userService.addUsers();
			return "index";
		}else {
			return "redirect:/view/login.jsp";
		}
				
	}

	@RequestMapping(value = "logout.do",method = RequestMethod.GET)
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/view/login.jsp";
	}
}
