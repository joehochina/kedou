package com.duoduo.mvnbook.account.persist;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class AccountPersistServiceImpl implements AccountPersistService {
	
	private static final String ELLEMENT_ROOT = "account-persist";
	private static final String ELLEMENT_ACCOUNTS = "account";
	private static final String ELEMENTS_ACCOUNTS = "accounts";
	private static final String ELEMENT_ACCOUNT_ID = "id";
	private static final String ELEMENT_ACCOUNT_NAME = "name";
	private static final String ELEMENT_ACCOUNT_PASSWORD = "password";
	private static final String ELEMENT_ACCOUNT_EMAIL = "email";
	private static final String ELEMENT_ACCOUNT_ACTIVATED = "activated";
	private String file="target/classes/account.xml";
	private SAXReader reader=new SAXReader();
	private Document readDocument() throws AccountPersistException{
		
		File dataFile=new File(file);
		if(!dataFile.exists()){
			dataFile.getParentFile().mkdirs();
			Document document = DocumentFactory.getInstance().createDocument();
			document.addElement(ELLEMENT_ROOT);
			document.addElement(ELLEMENT_ACCOUNTS);
			writeDocument(document);
		}
		
		try {
			return reader.read(new File(file));
		} catch (DocumentException e) {
			// TODO: handle exception
			throw new AccountPersistException("不能读取此 xml文件 ",e);
		}
	}

	private void writeDocument(Document document) throws AccountPersistException {
		Writer out=null;
		try {
			out=new OutputStreamWriter(new FileOutputStream(file),"utf-8");
			XMLWriter writer = new XMLWriter(out,OutputFormat.createPrettyPrint());
			writer.write(document);
		} catch (IOException e) {
			throw new AccountPersistException("不能写此 xml文件 ",e);
		}finally {
			try {
				if (out!=null) {
					out.close();
				}
				
			}catch (IOException e) {
				throw new AccountPersistException("不能关闭写入  xml文件 ",e);
			}
		}
		
	}

	@Override
	public Account createAccount(Account account) throws AccountPersistException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account readAccount(String id) throws AccountPersistException {
		Document doc = readDocument();
		Element accountsEle=doc.getRootElement().element(ELEMENTS_ACCOUNTS);
		for(Element accountEle:(List<Element>)accountsEle.elements()){
			if(accountEle.elementText(ELEMENT_ACCOUNT_ID).equals(id)){
				return buildAccount(accountEle);
			}
		}
		
		return null;
	}

	private Account buildAccount(Element element) {
		Account account = new Account();
		account.setId(element.elementText(ELEMENT_ACCOUNT_ID));
		account.setName(element.elementText(ELEMENT_ACCOUNT_NAME));
		account.setPassword(element.elementText(ELEMENT_ACCOUNT_PASSWORD));
		account.setEmail(element.elementText(ELEMENT_ACCOUNT_EMAIL));
		account.setActivated("true".equals(element.elementText(ELEMENT_ACCOUNT_ACTIVATED))?true:false);
		return account;
	}

	@Override
	public Account updateAccount(Account account) throws AccountPersistException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAccount(String id) throws AccountPersistException {
		// TODO Auto-generated method stub

	}

}
