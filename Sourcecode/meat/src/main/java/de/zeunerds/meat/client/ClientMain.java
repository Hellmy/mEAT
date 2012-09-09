package de.zeunerds.meat.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import de.zeunerds.meat.server.usermanagement.access.AccountAccess;

public class ClientMain {

	public static void main(String[] args) {
		ClientMain cm = new ClientMain();
	}

	public ClientMain() {
		Registry registry;
		try {
			registry = LocateRegistry.getRegistry();
			AccountAccess adder = (AccountAccess) registry
					.lookup("AccountAccess");
			System.out.println(adder.createAccount("test", "test", "test",
					"test"));

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
