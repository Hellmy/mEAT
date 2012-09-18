package de.zeunerds.meat.server.usermanagement.logic;

import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.zeunerds.meat.server.exception.FunctionalException;
import de.zeunerds.meat.server.usermanagement.dao.Account;
import de.zeunerds.meat.server.usermanagement.dao.Person;
import de.zeunerds.meat.server.usermanagement.dao.UsermanagementService;

public class UsermanagementLogic {
	
	private Logger mLogger = LoggerFactory.getLogger(this.getClass());
	private UsermanagementService userService = new UsermanagementService();

	public UsermanagementLogic() {
		
	}
	
	public Account createAccount(String username, String password, String name, String firstname) throws FunctionalException {
		
		return userService.createAccount(username, password, name, firstname);
		
	}

	public Account loadAccount(String username) {
		return userService.loadAccount(username);
		
	}
	
	public void saveAccount(Account account) {
		userService.saveAccount(account);
	}

	public List<Person> getPersons(String accountUsername) {
		return userService.getPersons(accountUsername);
	}
}
