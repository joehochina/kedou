package com.duoduo.mvnbook.account.persist;

import java.io.IOException;

import org.dom4j.DocumentException;

public class AccountPersistException extends Exception {

	public AccountPersistException(String string, DocumentException e) {
		e.printStackTrace();
	}

	public AccountPersistException(String string, IOException e) {
		e.printStackTrace();
	}

}
