package com.qs.web.fruit.test;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * 解决HttpUrlConnection乱码问题 
 * @author ASUS
 *
 */
public class UrlTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		String spec = "http://www.baidu.com/s?";
		String param = "中国";
		String tureParam = URLEncoder.encode(param, "utf-8");
		String tureUrl = spec+tureParam;
		System.out.println("--------"+tureUrl);
		URL url = new URL(tureUrl);
	    HttpURLConnection httpurlconnection = (HttpURLConnection) url.openConnection();
	    httpurlconnection.setDoOutput(true);
	    httpurlconnection.setRequestMethod("GET"); 
	    httpurlconnection.setRequestProperty("Content-type", "text/html");
	    httpurlconnection.setRequestProperty("Accept-Charset", "utf-8");
	    httpurlconnection.setRequestProperty("contentType", "utf-8");
	    /*发出请求*/
	    InputStream inStream = httpurlconnection.getInputStream();
	    byte[] bytes=new byte[1024];
	    int temp=0;
	    int len=0;
	    /*InputStream-->String 
	     * 将InputStream读到内存(byte[]数组中)
	     * 在用String构造方法输出
	     * */
	    while ((temp = inStream.read())!=-1) {
	    	bytes[len]=(byte)temp;
			len++;
		} 
	    inStream.close();
	    System.out.println("--输出结果--"+new String(bytes,"utf-8"));
	   /* BufferedReader in = new BufferedReader(new InputStreamReader(inStream, "GBK"));  
	    StringBuffer buffer = new StringBuffer();  
	    String line = "";  
	    while ((line = in.readLine()) != null){  
	    	buffer.append(line);  
	     }  
	    String str = buffer.toString(); */ 
	   /* System.out.println("-----返回结果-----"+str);*/

	}

}
