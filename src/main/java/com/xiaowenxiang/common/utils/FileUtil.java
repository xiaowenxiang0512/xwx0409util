package com.xiaowenxiang.common.utils;
//文件工具类(FileUtil.java)
public class FileUtil {
	/*
	* 方法1：给定一个文件名，返回该文件名的扩展名，例如“aaa.jpg”，返回“.jpg”(10分)
	*/
	public static String getExtendName(String fileName){
		if(!StringUtil.hasText(fileName)) 
			return null;
		
		return fileName.substring(fileName.lastIndexOf("."));
	}

}
