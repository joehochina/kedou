package com.duoduo.mvnbook;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.duoduo.mvnbook.account.email.AccountEmailService;
import com.duoduo.mvnbook.account.persist.AccountPersistService;

public class AccountPersistServiceTest {
	
	@Test
	public void test() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("account-persit.xml");
		AccountPersistService accountPersistService=(AccountPersistService) ctx.getBean("accountPersistService");
		
		
		accountPersistService.readAccount("duoduo");
	}

}
