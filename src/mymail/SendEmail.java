package mymail;

//��Ҫ�û��������ʼ�����ʵ��
//�ļ��� SendEmail2.java
//��ʵ����QQ����Ϊ��������Ҫ��qq��̨����

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
    // �ռ��˵�������
    String to = "xiaoyang4u@sina.com";

    // �����˵�������
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
		// ָ�������ʼ�������Ϊ localhost
		String host = "smtp.qq.com"; // QQ �ʼ�������

		// ��������
		Properties props = new Properties();
		// QQ���䷢���ķ������Ͷ˿�
		props.put("mail.smtp.host", "smtp.qq.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "25");

		// ��ȡĬ��session����
		Session session = Session.getDefaultInstance(props,
				new Authenticator() {
					public PasswordAuthentication getPasswordAuthentication() {

						// fcvfkqlyaxzpieic
						return new PasswordAuthentication("1575945217@qq.com",
								"fcvfkqlyaxzpieic"); // �������ʼ��û���������
					}
				});

		try {
			// ����Ĭ�ϵ� MimeMessage ����
			MimeMessage message = new MimeMessage(session);

			// Set From: ͷ��ͷ�ֶ�
			message.setFrom(new InternetAddress(from));

			// Set To: ͷ��ͷ�ֶ�
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));

//			// Set Subject: ͷ��ͷ�ֶ�
//			message.setSubject("Just4Test");
//
//			// ������Ϣ��
//			message.setText("this is houyafei mail");
			// Set Subject: ͷ��ͷ�ֶ�
			message.setSubject("һ�𳪰�");

			String[] str = {"����һֻС̫��������������","����������ѽ,����������","��ֻ�ϻ���ֻ�ϻ��ܵÿ�","һ��һ�������������춼��С����"};
			
			int i = (int)(Math.random()*10)%4;
			// ������Ϣ��
			message.setText(str[i]);
			// ������Ϣ
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