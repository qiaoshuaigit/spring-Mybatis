package com.qs.web.fruit.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import weibo4j.Oauth;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.WeiboException;
import weibo4j.util.BareBonesBrowserLaunch;

public class WeiBoAuth2 {

	public static void main(String[] args) throws IOException, WeiboException {
		Oauth oauth = new Oauth();
	    BareBonesBrowserLaunch.openURL(oauth.authorize("code", null, null));
	    System.out.println(oauth.authorize("code", null, null));
	    System.out.print("Hit enter when it's done.[Enter]:");
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String code = br.readLine();
	    Log.logInfo("code: " + code);
	    try {
	      System.out.println(oauth.getAccessTokenByCode(code));
	    } catch (WeiboException e) {
	      if (401 == e.getStatusCode()) {
	        Log.logInfo("Unable to get the access token.");
	      } else {
	        e.printStackTrace();
	      }
	    }
	}
}
