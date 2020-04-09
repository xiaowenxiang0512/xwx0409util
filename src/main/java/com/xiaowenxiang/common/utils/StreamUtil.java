package com.xiaowenxiang.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

//流处理工具类(StreamUtil.java)
public class StreamUtil {
	/*
	* 方法1：批量关闭流，参数能传入无限个。(10分)
	* 例如传入FileInputStream对象、JDBC中Connection对象都可以关闭，并且参数个数不限。
	*/
	public static void closeAll(AutoCloseable...autoCloseables ){
		//TODO 实现代码
		
		if(null !=autoCloseables && autoCloseables.length>0) {
			for (AutoCloseable autoCloseable2 : autoCloseables) {
				try {
					autoCloseable2.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	/*
	* 方法2：传入一个文本文件对象，默认为UTF-8编码，返回该文件内容(10分)，要求方法内部调用上面第1个方法关闭流(5分)
	*/
	public static String readTextFile(InputStream src){
		//TODO 实现代码
		byte[] b = new byte[1024];
		int x = 0;
		String str = "";
		try {
			while((x=src.read(b)) != -1) {
				str += new String(b,0,x,"utf-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(src);
		}
		return str;
	}
	
	/*
	* 方法3：传入文本文件对象，返回该文件内容(10分)，并且要求内部调用上面第2个方法(5分)。* 这是典型的方法重载，记住了吗？少年…
	*/
	public static String readTextFile(File txtFile) throws FileNotFoundException{
		
		return readTextFile(new FileInputStream(txtFile));
	}


}
