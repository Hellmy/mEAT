package de.zeunerds.meat.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;

import de.zeunerds.meat.server.usermanagement.access.AccountAccess;
import de.zeunerds.meat.server.usermanagement.access.AccountAccessImpl;

public class ServerMain {
	
	public ServerMain() {
		try
		{
		  LocateRegistry.createRegistry( Registry.REGISTRY_PORT );
		}
		catch ( RemoteException e )  { /* ... */ }
	}
	
	  public static void main( String[] args ) throws RemoteException
	  {
		  ServerMain sm = new ServerMain();
		  sm.register();

	    

	  }

	private void register() throws RemoteException {
		AccountAccessImpl adder = new AccountAccessImpl();
	    AccountAccess stub = (AccountAccess) UnicastRemoteObject.exportObject( adder, 0 );
	    RemoteServer.setLog( System.out );

	    Registry registry = LocateRegistry.getRegistry();
	    registry.rebind( "AccountAccess", stub );	
	    
	    System.out.println( "Adder angemeldet" );

	}
	  

}
