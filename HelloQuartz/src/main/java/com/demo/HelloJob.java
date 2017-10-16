package com.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @since
 * @param 
 * @return
 * @auther mhqi
 * @version 创建时间：2017年10月16日下午8:53:27
 */
public class HelloJob implements Job{

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// 打印当前的执行时间，格式为2017-01-01 00:00:00
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("当前执行时间为：" + sf.format(date));
		// 编写具体的业务逻辑
		System.out.println("Hello World!");
	}

}
