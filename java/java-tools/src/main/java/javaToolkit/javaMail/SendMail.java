package javaToolkit.javaMail;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 * @author zyy
 * 程序名称： sendMail
 * 程序功能： java用smtp服务发送邮件
 */

public class SendMail {
	
	public static void main(String[] args) {
		SendMail mymail = new SendMail();
		mymail.setSmtphost("smtp.163.com");//接收邮件使用pop.163.com
		mymail.setSmtpuser("username");
		mymail.setSmtppassword("password");
		mymail.setFrom("username@163.com");
		mymail.setTo("123@qq.com");
		mymail.setSubject("数据管理平台数据更新通知");
		String body = "尊敬的用户，您好\n相关的数据发生了变化，\n请及时登录查看详情。\n点击下面的链接进入平台 \n"
				+ "http:\\localhost:8080\\dmp"
				+ "<h4>HTML 格式的邮件测试！！！</h4> " +  
		        "<a href = http://www.baidu.com/>百度一下</a>";
		mymail.setBody(body);
		mymail.setBodyStyle("text/html;charset=GB2312");  //text/html对应html，text/plain对应文本
		//mymail.attachfile("C:\\inetpub\\wwwroot\\welcome.png");
		//mymail.attachfile("D:\\hhhh\\2.jpg");
		mymail.send();
	}
	
	public SendMail() {}

	private String smtphost; // SMTP转发服务器
	private String smtpuser; // SMTP转发的用户名
	private String smtppassword; // SMTP转发的用户密码
	private String from; // 发件人
	private String to; // 收件人
	private String subject; // 邮件标题
	private String body; // 邮件内容
	private String bodystyle; // 邮件内容的格式(默认为文本格式)
	private String filename; // 附件的文件名
	private Vector file = new Vector(); // 用于保存发送附件的文件名的集合

	/**
	 * 用于返回邮件SMTP转发服务器
	 */
	public String getSmtphost() {
		return smtphost;
	}

	/**
	 * 用于设置邮件SMTP转发服务器
	 */
	public void setSmtphost(String inString) {
		smtphost = inString;
	}

	/**
	 ** 用于返回邮件SMTP转发的用户名
	 */
	public String getSmtpuser() {
		return smtpuser;
	}

	/**
	 ** 用于设置邮件SMTP转发的用户名
	 */
	public void setSmtpuser(String inString) {
		smtpuser = inString;
	}

	/**
	 ** 用于返回邮件SMTP转发的用户密码
	 */
	public String getSmtppassword() {
		return smtppassword;
	}

	/**
	 ** 用于设置邮件SMTP转发的用户密码
	 */
	public void setSmtppassword(String inString) {
		smtppassword = inString;
	}

	/**
	 ** 用于返回邮件发件人
	 */
	public String getFrom() {
		return from;
	}

	/**
	 ** 用于设置邮件发件人
	 */
	public void setFrom(String inString) {
		from = inString;
	}

	/**
	 ** 用于返回邮件收件人
	 */
	public String getTo() {
		return to;
	}

	/**
	 ** 用于设置邮件收件人
	 */
	public void setTo(String inString) {
		to = inString;
	}

	/**
	 ** 用于返回邮件标题
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 ** 用于设置邮件标题
	 */
	public void setSubject(String inString) {
		subject = inString;
	}

	/**
	 ** 用于返回邮件内容
	 */
	public String getBody() {
		return body;
	}

	/**
	 ** 用于设置邮件内容
	 */
	public void setBody(String inString) {
		body = inString;
	}

	/**
	 ** 用于设置邮件内容的格式
	 */
	public void setBodyStyle(String inString) {
		bodystyle = inString;
	}

	/**
	 ** 该方法用于收集附件名
	 */
	public void attachfile(String fname) {
		file.addElement(fname);
	}

	/**
	 ** 用于邮件发送，返回发送结果 true为发送成功 false为发送失败
	 */
	public boolean send() {
		boolean result;

		if (smtphost == "" || smtphost == null) {
			System.out.println("An error ocur:smtp host is invalid!");
			return false;
		}

		if (from == "" || from == null) {
			System.out.println("An error ocur:mail sender is invalid!");
			return false;
		}

		if (to == "" || to == null) {
			System.out.println("An error ocur:mail reciever is invalid!");
			return false;
		}

		if (subject == "" || subject == null) {
			System.out.println("An error ocur:subject is invalid!");
			return false;
		}

		Properties props = System.getProperties();
		if (smtpuser == "" || smtpuser == null || smtppassword == ""
				|| smtppassword == null) {
			props.put("mail.smtp.host", smtphost);
		} else {
			props.put("mail.smtp.auth", "true");
		}
		Session session = Session.getInstance(props, null);
		try {
			System.out.println("开始发送邮件......");
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(from));
			InternetAddress[] address = { new InternetAddress(to) };
			msg.setRecipients(Message.RecipientType.BCC,
					InternetAddress.parse(to));
			msg.setSubject(subject);

			Multipart mp = new MimeMultipart();
			/*
			 * 后面的BodyPart将加入到此处 创建的Multipart中
			 */
			Enumeration efile = file.elements(); // 利用枚举器方便的遍历集合
			while (efile.hasMoreElements()) {
				MimeBodyPart mbp = new MimeBodyPart();
				filename = efile.nextElement().toString(); // 选择出每一个附件名
				FileDataSource fds = new FileDataSource(filename); // 得到数据源
				mbp.setDataHandler(new DataHandler(fds)); // 得到附件本身并置入BodyPart
				mbp.setFileName(fds.getName()); // 得到文件名同样置入BodyPart
				mp.addBodyPart(mbp);
			}
			System.out.println("附件上传完成！");
			file.removeAllElements(); // 移走集合中的所有元素
			MimeBodyPart mbp_body = new MimeBodyPart();
			mbp_body.setContent(body, bodystyle); // 加入邮件正文
			mp.addBodyPart(mbp_body);
			msg.setContent(mp); // Multipart加入到信件
			msg.setSentDate(new Date()); // 设置信件头的发送日期

			if (smtpuser == "" || smtpuser == null || smtppassword == ""
					|| smtppassword == null) {
				Transport.send(msg); // 发送信件
			} else {
				Transport trans = session.getTransport("smtp");
				trans.connect(smtphost, smtpuser, smtppassword);
				trans.sendMessage(msg, msg.getAllRecipients()); // 发送信件
				System.out.println("邮件发送完成！");
				trans.close();
			}
			result = true;
		} catch (MessagingException mex) {
			mex.printStackTrace();
			Exception ex = null;
			if ((ex = mex.getNextException()) != null) {
				ex.printStackTrace();
			}
			result = false;
		}
		return result;
	}
	
}
