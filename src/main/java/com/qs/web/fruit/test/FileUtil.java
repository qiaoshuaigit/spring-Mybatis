package com.qs.web.fruit.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 主要是测试将图片从一个文件夹读取到另一个文件夹
 * @author ASUS
 *
 */

public class FileUtil {
	
	private static String sourcePath="e:"+File.separator+"source";
	private static String targetPath="e:"+File.separator+"target";
	
	/**
	 * 复制一个图片
	 * @throws IOException
	 */
	public static void createNewImg() throws IOException{
		
		//首先指定要操作的图片(指定文件夹 和 指定文件名称)
		File fileSource = new File(sourcePath,"car.jpg");
		
		//将要操作的文件放到输入流中
		FileInputStream fileInputStream = new FileInputStream(fileSource);
		File file_target = new File(targetPath);
		file_target.mkdir();
		//指定要将操作的图片复制到的目标文件夹下(指定文件夹 和 指定文件名称)		
		File fileTarger = new File(file_target,"car_copy.jpg");
		//将要操作的文件图片放到输出六中
		FileOutputStream fileOutputStream = new FileOutputStream(fileTarger);
		//将文件写入到内容中   再将图片放到目标文件夹中
		byte[] bb = new byte[1024];
		int length=0;
		while ((length = fileInputStream.read(bb))>0) {
			fileOutputStream.write(bb,0,length);			
		}
		fileOutputStream.close();
		fileInputStream.close();
	}

	/**
	 * 复制多个图片
	 * @throws IOException
	 */
	public static void createNewImgList() throws Exception{
	
		//首先指定要操作的图片(指定文件夹 和 指定文件名称)
		File file_Source = new File(sourcePath);
		if (!file_Source.exists()) {
			throw(new Exception("sorry!源文件不存在"));
		}else {
			String[] fileNames = file_Source.list();
			for (int i = 0; i < fileNames.length; i++) {
				System.out.println(fileNames[i]);
				outStreamFile(fileNames[i]);
			}
		}	
	}
	/**
	 * 将图片从源文件夹copy到目标文件夹
	 * @param in
	 * @param out
	 * @throws Exception
	 */
	private static void copyFile(FileInputStream in,FileOutputStream out) throws Exception{
		byte[] bb = new byte[1024];
		int length=0;
		while ((length = in.read(bb))>0) {
			out.write(bb,0,length);			
		}
		in.close();
		out.close();		
	}

	private static void outStreamFile(String fileName) throws Exception{
		//指定要操作的文件
		File fileSource = new File(sourcePath,fileName);
		//将要操作的文件放到输入流中
		FileInputStream fileInputStream = new FileInputStream(fileSource);
		File file_target = new File(targetPath);
		//判断文件夹是否存在(.exists()也可以判断文件是否存在)
		if (!file_target.exists()) {
			//创建文件夹
			file_target.mkdir();
		}
		//指定要将操作的图片复制到的目标文件夹下(指定文件夹 和 指定文件名称)		
		File fileTarger = new File(file_target,fileName);
		if (fileTarger.exists()) {
			System.out.println(fileName+"此文件已经存在");
		}
		//将要操作的文件图片放到输出六中
		FileOutputStream fileOutputStream = new FileOutputStream(fileTarger);
		//将文件写入到内容中   再将图片放到目标文件夹中
		copyFile(fileInputStream,fileOutputStream);

	}
	
	public static void main(String[] args) {
		try {
			createNewImgList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
