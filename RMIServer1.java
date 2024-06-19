package BMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RMIServer1 {
	public static void main(String[] args) throws RemoteException {
		LocateRegistry.createRegistry(9986);
		while(true);
	}
}
