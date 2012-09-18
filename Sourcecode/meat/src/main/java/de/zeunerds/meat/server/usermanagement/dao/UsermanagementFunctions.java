package de.zeunerds.meat.server.usermanagement.dao;

import java.util.ArrayList;
import java.util.List;

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

	public List<Person> getPersons(long accountPkey, Session session) {
		
		Query query = session.createQuery("from Person where creatorFkey=" + accountPkey );
		
		List<Person> listPersons = query.list();
		
		return listPersons;
		
	}
	  
	
	public Person getPerson(String name, long accountPkey, Session session) {
		Person person = null;
		
		return person;
	}
}
