package com.duoduo.mvnbook.account.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class AccountEmailServiceImpl implements AccountEmailService {
	
	private JavaMailSender javaMailSender;
	private String systemEmail;
	
	public void sendMail(String to, String subject, String mailText) throws AccountEmailException {
		
		try {
			MimeMessage msg = javaMailSender.createMimeMessage();
			MimeMessageHelper msgHelper = new MimeMessageHelper(msg);
			msgHelper.setFrom(systemEmail);
			msgHelper.setTo(to);
			msgHelper.setSubject(subject);
			msgHelper.setText(mailText,true);
			
			javaMailSender.send(msg);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			throw new AccountEmailException("发送邮件失败", e);
		}
	}
	public JavaMailSender getJavaMailSender() {
		return javaMailSender;
	}

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	public String getSystemEmail() {
		return systemEmail;
	}
	public void setSystemEmail(String systemEmail) {
		this.systemEmail = systemEmail;
	}

}
