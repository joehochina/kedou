package com.duoduo.mvnbook.account.email;

import javax.mail.MessagingException;

public class AccountEmailException extends Exception {

	public AccountEmailException(String message, MessagingException e) {
		System.out.println(message +":"+ e.getMessage());
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
