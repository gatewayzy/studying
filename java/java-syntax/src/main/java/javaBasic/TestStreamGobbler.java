package javaBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * {@link http://hellsing42.iteye.com/blog/118317}<br>
 * 如果不使用StreamGobbler把inputstream清空的话,就会造成进程被堵死,从而导致waitFor()一直等下去,永远结束不了.
 * 
 * @author dell
 *
 */
public class TestStreamGobbler {

	public static void main(String args[]) {

		streamGobbler("javac");
		streamGobbler("java -version");
		streamGobbler("cmd.exe /C copy TestMath.java TestMath1.java ");
		streamGobbler("cmd.exe dir");
	}

	/**
	 * 用StreamGobbler清空输入流
	 * 
	 * @param cmd
	 */
	private static void streamGobbler(String cmd) {
		try {
			String osName = System.getProperty("os.name");
			System.err.println(cmd);
			System.out.println("osName: " + osName);

			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec(cmd);
			// any error message?
			StreamGobbler errorGobbler = new StreamGobbler(proc.getErrorStream(), "ERROR");
			// any output?
			StreamGobbler outputGobbler = new StreamGobbler(proc.getInputStream(), "OUTPUT");
			
			// kick them off
			errorGobbler.start();
			outputGobbler.start();

			// 等到子线程结束
			int exitVal = proc.waitFor();
			System.out.println("ExitValue: " + exitVal + "\r\n");

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}

/**
 * StreamGobbler作为单独的线程，读取inputstream所有内容，防止被堵住
 * 
 * @author dell
 *
 */
class StreamGobbler extends Thread {
	InputStream is;
	String type; // 输出流的类型ERROR或OUTPUT

	StreamGobbler(InputStream is, String type) {
		this.is = is;
		this.type = type;
	}

	public void run() {
		try {
			InputStreamReader isr = new InputStreamReader(is, "GB2312");
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(type + ">" + line);
				System.out.flush();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}