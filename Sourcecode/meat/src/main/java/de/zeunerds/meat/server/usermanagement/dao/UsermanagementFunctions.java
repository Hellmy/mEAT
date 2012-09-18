package de.zeunerds.meat.server.usermanagement.dao;

import org.hibernate.Query;
import org.hibernate.Session;

public class UsermanagementFunctions {
	
	UsermanagementFunctions() {
		
	}

	public Account loadAccount(String username, Session session) {
		Account account = null;
		Query query = session.createQuery("from Account where username='"
				+ username + "'");
		if(query.list().size() > 0) {
			account = (Account) query.list().get(0);
		}
				
		return account;
	}
}
