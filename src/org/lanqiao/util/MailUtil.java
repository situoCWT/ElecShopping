package org.lanqiao.util;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

public class MailUtil {
	static final String from = "347095722@qq.com";
	static final String authPassword = "oouyqpvqjtnnbjch";
	static final String to = "526718228@qq.com";
	static final String smtpHost = "smtp.qq.com";

	public void sendMail(String mailaddress, String subject, String content) {
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.host", smtpHost);
		props.setProperty("mail.smtp.auth", "true");
		// 创建验证器
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from,
						authPassword);// 客户端授权密码
			}
		};

		Session session = Session.getInstance(props, auth);

		// qq邮箱开启ssl认证
		MailSSLSocketFactory sf = null;
		try {
			sf = new MailSSLSocketFactory();
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sf.setTrustAllHosts(true);
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.socketFactory", sf);

		// 创建邮件
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(from, "你好", "UTF-8"));
			message.setRecipient(MimeMessage.RecipientType.TO,
					new InternetAddress(mailaddress, "你好", "UTF-8"));
			message.setSubject(subject);
			message.setContent(content, "text/html;charset=UTF-8");
			message.setSentDate(new Date());

			Transport transport = session.getTransport();
			transport.connect(from, authPassword);
			transport.send(message, message.getAllRecipients());
			transport.close();

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
