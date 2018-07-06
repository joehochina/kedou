package com.duoduo.mvnbook;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.duoduo.mvnbook.account.email.AccountEmailService;

public class AccountEmailServiceTest {
	
	@Test
	public void test() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("account-email.xml");
		AccountEmailService accountEmailService=(AccountEmailService) ctx.getBean("accountEmailService");
		
		String subject="test subject";
		String mailText="<h2>test email</h2>";
		accountEmailService.sendMail("xupeng@duoduobird.com", subject, mailText);		
	}

}
