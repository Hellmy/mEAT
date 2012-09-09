package de.zeunerds.meat.server.usermanagement.logic;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.zeunerds.meat.server.exception.FunctionalException;
import de.zeunerds.meat.server.usermanagement.dao.Account;
import de.zeunerds.meat.server.usermanagement.dao.UsermanagementService;

public class AccountLogic {
	
	private Logger mLogger = LoggerFactory.getLogger(this.getClass());
	private UsermanagementService userService = new UsermanagementService();

	public AccountLogic() {
		
	}
	
	public Account createAccount(String username, String password, String name, String firstname) throws FunctionalException {
		
		return userService.createAccount(username, password, name, firstname);
		
	}

	public Account loadAccount(String username) {
		return userService.loadAccount(username);
		
	}
}
