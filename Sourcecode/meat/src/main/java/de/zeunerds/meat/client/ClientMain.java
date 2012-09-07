package de.zeunerds.meat.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import de.zeunerds.meat.server.usermanagement.access.AccountAccess;

public class ClientMain {
	
	 public static void main( String[] args ) throws  RemoteException, NotBoundException
	  {
	    Registry registry = LocateRegistry.getRegistry();
	    AccountAccess adder = (AccountAccess) registry.lookup( "AccountAccess" );
	    System.out.println( adder.createAccount( "test", "test", "test", "test" ) );
	  }

}
