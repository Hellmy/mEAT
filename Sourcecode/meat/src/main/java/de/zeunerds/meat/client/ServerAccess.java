package de.zeunerds.meat.client;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerAccess {
	
	private static ServerAccess mServerAccess = null;
	
	private Logger mLogger = LoggerFactory.getLogger(this.getClass());
	
	private ServerAccess() {

	}
	
	public static synchronized ServerAccess getInstance() {
		if(mServerAccess == null) {
			mServerAccess = new ServerAccess();
		}
		return mServerAccess;
	}
	
	public Remote lookup(String name) {
		Registry registry;
		Remote remote = null;
		try {
			registry = LocateRegistry.getRegistry();
			remote = registry.lookup(name);
		}
		catch(RemoteException e) {
			mLogger.error("RegistryError", e);
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			mLogger.error("RegistryError", e);
		}
		return remote;
	}
	
	

}
