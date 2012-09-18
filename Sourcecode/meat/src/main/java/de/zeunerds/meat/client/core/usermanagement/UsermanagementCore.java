package de.zeunerds.meat.client.core.usermanagement;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Observable;

import de.zeunerds.meat.client.ServerAccess;
import de.zeunerds.meat.server.usermanagement.dao.Account;
import de.zeunerds.meat.server.usermanagement.dao.Person;
import de.zeunerds.meat.shared.usermanagement.UsermanagementAccess;

public class UsermanagementCore extends Observable implements
		UsermanagementAccess {

	/*
	 * Hier wird die Logik und die Datenhaltung eingebaut Die
	 * Präsentationsschicht registriert sich als Observer Die Dialogschicht muss
	 * Observable sein!!!
	 * Datenhaltung ist wichtig!!! Die Daten müssen von der Präsentationsschicht abgeholt werden
	 */

	public Account loadAccount(String username) {
		Account account = null;
		try {
			UsermanagementAccess adder = (UsermanagementAccess) ServerAccess
					.getInstance().lookup(UsermanagementAccess.class.getName());
			account = adder.loadAccount(username);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setChanged();
		notifyObservers(account);

		return account;
	}

	public Account createAccount(String username, String password, String name,
			String firstname) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Person> getPersons(String accountUsername)
			throws RemoteException {
		List<Person> listPersonen = null;
		try {
			UsermanagementAccess adder = (UsermanagementAccess) ServerAccess
					.getInstance().lookup(UsermanagementAccess.class.getName());
			listPersonen = adder.getPersons(accountUsername);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listPersonen;
	}

	public List<Account> searchAccount(String username) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveAccount(Account account) throws RemoteException {
		Registry registry;
		try {
			UsermanagementAccess adder = (UsermanagementAccess) ServerAccess
					.getInstance().lookup(UsermanagementAccess.class.getName());
			adder.saveAccount(account);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
