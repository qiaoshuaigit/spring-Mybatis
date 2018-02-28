package com.qs.web.fruit.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import weibo4j.model.WeiboException;
@Controller
public class WeiBoController {
	
	@RequestMapping(value="/weiboLogin.do")
	public ModelAndView weiboLogin(HttpServletRequest request,String history) {
	/*	weibo4j.Oauth oauth = new weibo4j.Oauth();
		String url="";
		try {
			url = oauth.authorize("code",null,null);
		} catch (WeiboException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-----BareBonesBrowserLaunch---------"+url);
		BareBonesBrowserLaunch.openURL(url);*/
		
		ModelAndView mv = new ModelAndView();
		String redirect_uri="http://wap.api.audi-online.cn/weiboCallBack.do?returnurl="+history;		
		String oauthUri="https://api.weibo.com/oauth2/authorize?client_id=3364758610&redirect_uri="+redirect_uri+"&response_type=code&state=null&scope=null";
		mv.setView(new RedirectView(oauthUri));
		return mv;
	}
	@RequestMapping(value="/weiboCallBack.do")
	public void weiboCallBack(HttpServletRequest request) {	
		System.out.println("====super.weiboCallBack====");
		String code = request.getParameter("code");
		System.out.println("-------here-is-code-----"+code);
		weibo4j.Oauth oauth = new weibo4j.Oauth();
		try {
			oauth.authorize("code",null,null);
			weibo4j.http.AccessToken accessTokenByCode = oauth.getAccessTokenByCode(code);
			String accessToken = accessTokenByCode.getAccessToken();
			System.out.println("-------this--is---accesstoken-----"+accessToken);
			/*Account account = new Account();
			account.setToken(accessTokenByCode.getAccessToken());		
			JSONObject uid = account.getUid();
			logger.info("=====Uid0===="+uid);
			String sinaId = uid.getString("uid");
			logger.info("=====Uid1===="+sinaId);*/
		}catch (WeiboException e) {
			e.printStackTrace();
		}
		
		/*ModelAndView mv = new ModelAndView();
		String returnUrl = request.getParameter("returnurl");
		mv.setViewName(returnUrl);				
		return mv;*/
	}
	public static void main(String[] args) throws Exception {
			
			weibo4j.Oauth oauth = new weibo4j.Oauth();
			/*String url = oauth.authorize("code",null,null);
			System.out.println(url);
			BareBonesBrowserLaunch.openURL(url);*/
			System.out.print("Hit enter when it's done.[Enter]:");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String code = br.readLine();
			try{
				//System.out.println("---here--is--token----"+oauth.getAccessTokenByCode(code));
				weibo4j.http.AccessToken accessTokenByCode = oauth.getAccessTokenByCode(code);
				/*Account account = new Account();
				account.setToken(accessTokenByCode.getAccessToken());
				JSONObject uid = account.getUid();*/
				String sinaId = accessTokenByCode.getAccessToken();
				System.out.println("-----this-is-sinaId----"+sinaId);
			} catch (WeiboException e) {
				if(401 == e.getStatusCode()){
					System.out.println("Unable to get the access token.");
				}else{
					e.printStackTrace();
				}
			}
		}

}
