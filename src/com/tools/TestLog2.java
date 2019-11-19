package com.tools;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestLog2 {
			 	
	public static void main(String[] args) throws InterruptedException {
				
		// Logger logger1 = Logger.getLogger(TestLog2.class);
		// 1 绝对路径的获取
		String projectDir = TestLog2.class.getClass().getResource("/").getPath();
		System.setProperty("base.dir", TestLog2.class.getResource("/").getPath());
		System.out.println(System.getProperty("base.dir"));
		
		// 2 Read the configuration file configFilename if it exists.
		// 这里相当于重新加载，让绝对路径的配置生效;		
		PropertyConfigurator.configure(projectDir + "log4j.properties");
		
		// 存放绝对路径的系统变量，被Log4j加载的测试
		FileAppender appender= (FileAppender) Logger.getRootLogger().getAppender("file");//获取FileAppender对象
		System.out.println(appender.getFile());
		
		// 3 实例化Logger;
		Logger logger3 = Logger.getLogger(TestLog2.class);
				
		int cnt = 0;
		while(true) {
						
//			logger1.info(cnt + "");
//			logger2.info(cnt + "");
			logger3.info(cnt + "");
			cnt++;
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
	}
	
}
