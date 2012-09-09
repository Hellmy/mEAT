package de.zeunerds.meat.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.zeunerds.meat.server.usermanagement.access.AccountAccess;
import de.zeunerds.meat.server.usermanagement.access.AccountAccessImpl;

public class ServerMain {
	
	private Logger mLogger = LoggerFactory.getLogger(this.getClass());
	
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
		AccountAccessImpl accountAccess = new AccountAccessImpl();
	    AccountAccess stub = (AccountAccess) UnicastRemoteObject.exportObject( accountAccess, 0 );
	    RemoteServer.setLog( System.out );
	    
	    Registry registry = LocateRegistry.getRegistry();
	    registry.rebind( "AccountAccess", stub );
	    
	    mLogger.info( "AccountAccess angemeldet");

	}
	  

}
