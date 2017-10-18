package com.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @since
 * @param
 * @return
 * @auther mhqi
 * @version 创建时间：2017年10月16日下午9:04:46
 */
public class HelloScheduler {

	public static void main(String[] args) throws SchedulerException {
		// 打印当前的时间，格式为2017-01-01 00:00:00
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("当前时间为：" + sf.format(date));
		// 创建一个JobDetail实例，将该实例与HelloJob class绑定
		JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("myjob", "group1").build();
		// 创建距离当前时间3秒后的时间
		date.setTime(date.getTime() + 3000);
		// 创建距离当前时间6秒后的时间
		Date endDate = new Date();
		endDate.setTime(endDate.getTime() + 6000);
		// 创一个Trigger实例，定义该job立即执行并且每隔2秒执行一次
		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("myTrigger", "group1")
				.startAt(date)
				.endAt(endDate)
				.withSchedule(SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(2).repeatForever()).build();
		// 創建Schedule实例
		SchedulerFactory sFactory = new StdSchedulerFactory();
		Scheduler scheduler = sFactory.getScheduler();
		scheduler.start();
		
		scheduler.scheduleJob(jobDetail, trigger);
	}

}
