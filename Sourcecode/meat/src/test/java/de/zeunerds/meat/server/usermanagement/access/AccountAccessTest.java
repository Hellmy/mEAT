package de.zeunerds.meat.server.usermanagement.access;

import org.junit.Test;

import de.zeunerds.meat.server.HibernateUtils;
import de.zeunerds.meat.server.usermanagement.dao.Account;

import junit.framework.TestCase;

public class AccountAccessTest extends TestCase {
	
	private AccountAccessImpl mAccImpl = new AccountAccessImpl();
	private final String USERNAME = "testor";
	private final String PASSWORD = "test";
	private final String NAME = "test";
	private final String FIRSTNAME = "so";
	
	public void setUp() {
//		HibernateUtils.generateSchema();
	}
	
	@Test
	public void testCreateAccount() {
		Account account = mAccImpl.createAccount(USERNAME, PASSWORD, NAME, FIRSTNAME);
		assertEquals(USERNAME, account.getUsername());
		assertEquals(PASSWORD, account.getPassword());
		assertEquals(NAME, account.getName());
		assertEquals(FIRSTNAME, account.getFirstname());
	}
	
	@Test
	public void testLoadAccount() {
		Account account = mAccImpl.loadAccount(USERNAME);
		assertEquals(USERNAME, account.getUsername());
		assertEquals(PASSWORD, account.getPassword());
		assertEquals(NAME, account.getName());
		assertEquals(FIRSTNAME, account.getFirstname());
	}

}
