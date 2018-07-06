package com.duoduo.mvnbook.account.email;

public interface AccountEmailService {
	public void sendMail(String to,String subject,String mailText) throws AccountEmailException;
}
