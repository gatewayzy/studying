package javaBasic;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 使用 Runtime.getRuntime().exec(cmd 命令)
 */
public class _01RuntimeExcCMD {
	public static void main(String args[]) {
		runtime1();
		runtime2();
	}


	private static void runtime2() {
		System.err.println("系统编码为：" + System.getProperty("file.encoding"));
		try {
			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec("javac");
			InputStream stderr = proc.getErrorStream();
			// 控制台进来的字符编码是GB2312
			InputStreamReader isr = new InputStreamReader(stderr, "GB2312");
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			System.out.println("<ERROR>");
			while ((line = br.readLine()) != null)
				System.out.println(line);
			System.out.println("</ERROR>");
			int exitVal = proc.waitFor();
			System.out.println("Process exitValue: " + exitVal);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	/**
	 * 标准输入和输出流所提供的缓冲区大小有限,如果不能及时写入子进程的输入流或者读取子进程的输出流,可能导致子进程阻塞,甚至陷入死锁
	 */
	private static void runtime1() {
		try {
			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec("javac");
			// 运行javac命令缺少参数，系统输出帮助说明
			int exitVal = proc.waitFor();
			// 输出命令运行时间
			System.out.println("Process exitValue: " + exitVal);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
