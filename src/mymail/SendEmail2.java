package mymail;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
 
public class SendEmail2
{
   public static void main(String [] args)
   {   
      // �ռ��˵�������
      String to = "xiaoyang4u@sina.com";
 
      // �����˵�������
      //String from = "xiaoyang4u@sina.com";
   // �����˵�������
      String from = "yafeihou@sina.com";
 
      // ָ�������ʼ�������Ϊ localhost
      String host = "localhost";
 
      for (int i = 0; ; i++) {
    	  sendMail(to, from) ;
    	  try {
    		 int time = (int)(Math.random()*20) ;
			Thread.sleep(3000*time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
     
   }

	private static boolean sendMail(String to, String from) {
		// ��ȡϵͳ����
		Properties props = System.getProperties();

		// �����ʼ�������
		// properties.setProperty("mail.smtp.host", host);
		// Properties props = new Properties();
		// QQ���䷢���ķ������Ͷ˿�
		props.put("mail.smtp.host", "smtp.sina.com");
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
//						return new PasswordAuthentication("xiaoyang4u@sina.com",
//								"xiaoyangforu"); // �������ʼ��û���������
						return new PasswordAuthentication("yafeihou@sina.com","******");
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

			// Set Subject: ͷ��ͷ�ֶ�
			message.setSubject("һ�𳪰�");

			String[] str = {"����һֻС̫��������������","����������ѽ,����������","��ֻ�ϻ���ֻ�ϻ��ܵÿ�","һ��һ�������������춼��С����"};
			
			int i = (int)(Math.random()*10)%4;
			// ������Ϣ��
			message.setText(str[i]);

			// ������Ϣ
			Transport.send(message);
			System.out.println("Sent message successfully....");
			return true ;
		} catch (MessagingException mex) {
			mex.printStackTrace();
			return false ;
		}
	}
}