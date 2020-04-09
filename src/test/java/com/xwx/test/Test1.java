package com.xwx.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.xiaowenxiang.common.utils.DateUtil;
import com.xiaowenxiang.common.utils.FileUtil;
import com.xiaowenxiang.common.utils.StreamUtil;
//测试类
public class Test1 {
	/*String sql = "select * from t_order where create_time>='{1}' and create_time<='{2}' ";
	将上面{1}的位置使用DateUtil工具类中的getDateByInitMonth()返回值替换，将上面{2}的位置使用DateUtil工具类中的getDateByFullMonth()返回值替换。最后打印出正确拼接的SQL字符串。*/

	@Test
	public void testSql() {
		Date date = DateUtil.getDateByInitMonth(new Date());
		Date date2 = DateUtil.getDateByFullMonth(new Date());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		
		String d1 = df.format(date);
		String d2 = df.format(date2);
		
		String sql = "select * from t_order where create_time>='{1}' and create_time<='{2}' ";
		String sql2 = sql.replace("{1}", d1).replace("{2}", d2);
		System.err.println(sql2);
	}
	
	
	
	//测试日期工具类方法一
	@Test
	public void dateTest1() {
		Calendar c = Calendar.getInstance();
		c.set(2008, 6,4);
		Date date = DateUtil.getDateByInitMonth(c.getTime());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(date));
	}
	
	//测试日期工具类的方法二
	@Test
	public void dateTest2() {
		Calendar c = Calendar.getInstance();
		c.set(2020, 4,1);
		Date date = DateUtil.getDateByFullMonth(c.getTime());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(date));
	}
	//测试文件工具类
	@Test 
	public void fileTest1() {
		System.out.println(FileUtil.getExtendName("1710D.txt"));
	}
	//测试关闭流
	@Test
	public void testCloseAll() {
		AutoCloseable autoCloseables = null;
		StreamUtil.closeAll(autoCloseables);
		System.out.println("已关闭");
	}
	
	//传入文本文件对象，返回该文件内容
	@Test
	public void testReadTextFile() throws FileNotFoundException {
		String file = StreamUtil.readTextFile(new File("D:/data.txt"));
		System.out.println(file);
	}
}
