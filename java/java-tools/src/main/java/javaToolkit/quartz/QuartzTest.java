package javaToolkit.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuartzTest {

	public static void main(String[] args) {
		SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = new Date();
		String returnstr = DateFormat.format(d);

		TestJob job = new TestJob();
		String job_name = "11";
		try {
			// 每2秒钟执行一次
			System.out.println(returnstr + "【系统启动】");
			QuartzManager.addJob(job_name, job, "0/2 * * * * ?");
			Thread.sleep(10 * 1000);

			// 更改任务设置，好像不起作用，可以移除再添加一个任务
			System.out.println(returnstr + "【修改时间】");
			QuartzManager.modifyJobTime(job_name, "0/5 * * * * ?");
			Thread.sleep(10 * 1000);

			// 移除任务
			System.out.println(returnstr + "【移除定时任务】");
			QuartzManager.removeJob(job_name);
			Thread.sleep(10 * 1000);

			// 添加任务
			System.out.println(returnstr + "【添加定时任务】");
			QuartzManager.addJob(job_name, job, "0/5 * * * * ?");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
