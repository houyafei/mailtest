package mymail;

//需要用户名密码邮件发送实例
//文件名 SendEmail2.java
//本实例以QQ邮箱为例，你需要在qq后台设置

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail
{
 public static void main(String [] args)
 {
    // 收件人电子邮箱
    String to = "xiaoyang4u@sina.com";

    // 发件人电子邮箱
    String from = "1575945217@qq.com";
   int i = 0 ; 
    	while(sendMail(to, from)){
    		try {
    			int time = (int)(Math.random()*20) ;
    			Thread.sleep(3000*time);
				
				i++ ;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	};
 }

	private static boolean sendMail(String to, String from) {
		// 指定发送邮件的主机为 localhost
		String host = "smtp.qq.com"; // QQ 邮件服务器

		// 设置属性
		Properties props = new Properties();
		// QQ邮箱发件的服务器和端口
		props.put("mail.smtp.host", "smtp.qq.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "25");

		// 获取默认session对象
		Session session = Session.getDefaultInstance(props,
				new Authenticator() {
					public PasswordAuthentication getPasswordAuthentication() {

						// xxxxxxxx
						return new PasswordAuthentication("1575945217@qq.com",
								"xxxxxx"); // 发件人邮件用户名、密码
					}
				});

		try {
			// 创建默认的 MimeMessage 对象
			MimeMessage message = new MimeMessage(session);

			// Set From: 头部头字段
			message.setFrom(new InternetAddress(from));

			// Set To: 头部头字段
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));

//			// Set Subject: 头部头字段
//			message.setSubject("Just4Test");
//
//			// 设置消息体
//			message.setText("this is houyafei mail");
			// Set Subject: 头部头字段
			message.setSubject("一起唱吧");

			String[] str = {"你是一只小太阳，光明又闪亮","春天在哪里呀,春天在哪里","两只老虎两只老虎跑得快","一闪一闪亮晶晶，满天都是小星星"};
			
			int i = (int)(Math.random()*10)%4;
			// 设置消息体
			message.setText(str[i]);
			// 发送消息
			Transport.send(message);
			System.out
					.println("Sent message successfully....from w3cschool.cc");
			return true;
		} catch (MessagingException mex) {
			mex.printStackTrace();
			return false;
		}
}
}
