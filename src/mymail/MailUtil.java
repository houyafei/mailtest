package mymail;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {
    static int port = 587;
    
    static String server = "imap.sina.com";//�ʼ�������mail.cpip.net.cn
 
    static String from = "����";//������,��ʾ�ķ���������
 
    static String user = "";//�����������ַ
 
    static String password = "";//����
 
    
    public static void sendEmail(String email, String subject, String body) throws UnsupportedEncodingException {
        try {
            Properties props = new Properties();
            props.put("imap.sina.host",server);
            props.put("imap.sina.port","143");
            props.put("imap.sina.auth","true"); 
            Transport transport = null;
            Session session = Session.getDefaultInstance(props, null);
            transport = session.getTransport("imap");
            transport.connect(server, user, password);
            MimeMessage msg = new MimeMessage(session);
            msg.setSentDate(new Date());
            InternetAddress fromAddress = new InternetAddress(user,from,"UTF-8");
            msg.setFrom(fromAddress);
            InternetAddress[] toAddress = new InternetAddress[1];
            toAddress[0] = new InternetAddress(email);
            msg.setRecipients(Message.RecipientType.TO, toAddress);
            msg.setSubject(subject, "UTF-8");   
            msg.setText(body, "UTF-8");
            msg.saveChanges();
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]) throws UnsupportedEncodingException
    {
 
        sendEmail("1575945217@qq.com","eee","ww");//�ռ���
        System.out.println("ok");
    }
}
