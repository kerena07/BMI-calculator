package BMI;

import java.rmi.RemoteException;
import java.rmi.registry.*;

public class RegisterwithRMIServer1 {
	public static void main(String[] args) {
		try {
			BMIServerInterface bmi = new BMIServerInterfaceIMPL() ;
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind("bmiserverinterface", bmi);
			System.out.println("BMI SERVER " + bmi + " CONNECTED");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}

}

