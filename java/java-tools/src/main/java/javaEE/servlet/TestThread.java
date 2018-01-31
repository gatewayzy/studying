package javaEE.servlet;

public class TestThread extends Thread{
	@Override
	public void run() {
		int i = 0;
		try {
			while (true) {
				Thread.sleep(2*1000);
				System.out.println("每2秒刷新一次，i=" + i++);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
