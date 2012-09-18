package de.zeunerds.meat.shared.usermanagement;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import de.zeunerds.meat.server.usermanagement.dao.Account;
import de.zeunerds.meat.server.usermanagement.dao.Person;

public interface UsermanagementAccess extends Remote {
	
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

	/**
	 * Loads an existing Account.
	 * @param username the username of the account
	 * @return
	 * @throws RemoteException
	 */
	// TODO Check password to load an account?
	public Account loadAccount(String username) throws RemoteException;
	
	public List<Person> getPersons(String accountUsername)  throws RemoteException;
	
	public List<Account> searchAccount(String username) throws RemoteException;
	
	public void saveAccount(Account account) throws RemoteException;
	
}
