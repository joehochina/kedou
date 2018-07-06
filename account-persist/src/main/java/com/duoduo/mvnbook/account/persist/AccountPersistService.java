package com.duoduo.mvnbook.account.persist;

public interface AccountPersistService {
	public Account createAccount(Account account) throws AccountPersistException;
	public Account readAccount(String id) throws AccountPersistException;
	public Account updateAccount(Account account) throws AccountPersistException;
	public void deleteAccount(String id) throws AccountPersistException;

}
