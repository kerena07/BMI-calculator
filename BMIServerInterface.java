package BMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BMIServerInterface extends Remote {
	public double getBMI(double height, double weight) throws RemoteException;
}

