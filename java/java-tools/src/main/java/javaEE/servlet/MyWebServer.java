package javaEE.servlet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * use socket to implement a webserver
 * 
 * @Attention: use IE or Firefox not Chrome to visit 127.0.0.1:port
 * 
 * @author dell
 *
 */
public class MyWebServer {
	public static void main(String[] args) throws Exception {
		System.out.println("javaEE.servlet...");
		int port = 8085;
		ServerSocket serverSocket = new ServerSocket(port);
		System.out.println("listening on port:" + port);
		Socket socket = serverSocket.accept();
		OutputStream outputStream = socket.getOutputStream();

		BufferedReader bReader = new BufferedReader(new FileReader("src/main/resources/javaEE.servlet/MyWebServer.html"));
		String buf = "";
		while ((buf = bReader.readLine()) != null) {
			outputStream.write(buf.getBytes());
		}

		bReader.close();
		outputStream.close();
		socket.close();
	}

}
