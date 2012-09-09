package de.zeunerds.meat.server.usermanagement.access;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import de.zeunerds.meat.server.usermanagement.dao.Account;
import de.zeunerds.meat.server.usermanagement.dao.Person;

public interface AccountAccess extends Remote {
	
	/**
	 * Creates a new Account.
	 * @param username the individual username
	 * @param password a secure password
	 * @param name the name of the user
	 * @param firstname the fistname of the user
	 * @return
	 * @throws RemoteException
	 */
	public Account createAccount(String username, String password, String name, String firstname) throws RemoteException;

	public Account loadAccount(String username) throws RemoteException;
	
	public List<Person> getPersonen(String accountUsername)  throws RemoteException;
}
