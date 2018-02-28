package com.qs.web.fruit.test;

import java.text.MessageFormat;

/**
 * MessageFormat用来格式化一个消息，通常是一个字符串
 *
 */
public class MessageFormatUtil {

	public static void main(String[] args) {
		String pig="{0}{1}{2}{3}{4}";
		Object[] array=new Object[]{"you "," are"," a"," dog","!","!"};
		String formatMes=MessageFormat.format(pig, array);
		System.out.println(formatMes);
	}
}
