package com.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.Context;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.Trigger;

/**
 * @since
 * @param
 * @return
 * @auther mhqi
 * @version 创建时间：2017年10月16日下午8:53:27
 */
public class HelloJob implements Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {
		// 打印当前的执行时间，格式为2017-01-01 00:00:00
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("当前执行时间为：" + sf.format(date));
		// 编写具体的业务逻辑
		System.out.println("Hello World!");
		Trigger currentTrriger = context.getTrigger();
		System.out.println("Start Time is:" + sf.format(currentTrriger.getStartTime()));
		System.out.println("End Time is:" + sf.format(currentTrriger.getEndTime()));
		JobKey jobKey = currentTrriger.getJobKey();
		System.out.println("jobKey info---" + "JobName" + jobKey.getName() + 
				"jobGroup" + jobKey.getGroup());
	}

}
