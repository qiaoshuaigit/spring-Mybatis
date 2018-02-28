package com.qs.web.fruit.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 获取属性文件
 * @author ASUS
 *
 */
@Component("propertyData")
public class PropertyData{
	@Value("${database.username}")
	public String name;
	@Value("${database.url}")
	public String url;
	@Value("${database.password}")
	public String pass;
	@Value("${utf}")
	public String utf;
	
	public String getName() {
		return name;
	}
	public String getUrl() {
		return url;
	}

	public String getPass() {
		return pass;
	}

	public String getUtf() {
		return utf;
	}


/*public String toString() {
	
	return ToStringBuilder.reflectionToString(this);
}*/	
}

