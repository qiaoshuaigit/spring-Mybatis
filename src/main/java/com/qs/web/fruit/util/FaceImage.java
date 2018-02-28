package com.qs.web.fruit.util;

public class FaceImage {
	
	static void getImage(){
		String picAndTex="这是什么{aa:a}这是图片{2:jpg}宝马车{2:jpg}do you like?[aaa]";
		picAndTex.replaceAll("{aa:a}", "<img src='1.jpg'>");
		System.out.println(picAndTex);
		
	}
	public static void main(String[] args) {
		getImage();
	}
}
