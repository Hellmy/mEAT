package de.zeunerds.meat.server.usermanagement.access;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.zeunerds.meat.server.exception.FunctionalException;
import de.zeunerds.meat.server.exception.FunctionalText;
import de.zeunerds.meat.server.usermanagement.dao.Account;
import de.zeunerds.meat.server.usermanagement.dao.Person;
import de.zeunerds.meat.server.usermanagement.logic.UsermanagementLogic;
import de.zeunerds.meat.shared.usermanagement.UsermanagementAccess;

public class UsermanagementAccessImpl implements UsermanagementAccess {

	private Logger mLogger = LoggerFactory.getLogger(this.getClass());
	private UsermanagementLogic mAccountLogic = new UsermanagementLogic();
	Session mSession = null;

	public UsermanagementAccessImpl() {

	}

	public Account createAccount(String username, String password, String name,
			String firstname) throws RemoteException {
		// TODO In-Check gemäß:
		/*
		 * Um die Wertebereiche der beiden Datenwelten aufeinander abzubilden,
		 * müssen zunächst die gültigen Werte von den ungültigen Werten
		 * unterschieden werden. Diese Überprüfung bezeichnen wie als
		 * syntaktische Validierung. Wenn die fachlich sinnvollen Werte von den
		 * fachlich nicht sinnvollen Werten unterschieden werden sollen,
		 * sprechen wir von semantischer Validierung.
		 */
		Account account = null;
		if (username == null) {
			throw new RemoteException("TODO Iwas", new FunctionalException(
					FunctionalText.INVALID_USERNAME));
		} else if (password == null) {
			throw new RemoteException("TODO Iwas", new FunctionalException(
					FunctionalText.INVALID_PASSWORD));
		} else if (name == null) {
			throw new RemoteException("TODO Iwas", new FunctionalException(
					FunctionalText.INVALID_NAME));
		} else if (firstname == null) {
			throw new RemoteException("TODO Iwas", new FunctionalException(
					FunctionalText.INVALID_FIRSTNAME));
		}
		try {
			account = mAccountLogic.createAccount(username, password, name, firstname);
		} catch (FunctionalException e) {
			throw new RemoteException("TODO Iwas", e);
		}
		return account;

	}

	public Account loadAccount(String username) {
		// TODO In-Check
		return mAccountLogic.loadAccount(username);

	}

	public List<Person> getPersons(String accountUsername) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Account> searchAccount(String username) {
		List<Account> accountList = new ArrayList<Account>();
		
		
		return accountList;
	}

	public void saveAccount(Account account) throws RemoteException {
		mAccountLogic.saveAccount(account);
		
	}

}
