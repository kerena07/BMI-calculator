package BMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.security.KeyStore.TrustedCertificateEntry;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public	class BMIServerInterfaceIMPL extends UnicastRemoteObject implements BMIServerInterface{
		public BMIServerInterfaceIMPL() throws RemoteException {
		super();
		}

		@Override
		public double getBMI(double height, double weight) throws RemoteException {
			double	bmi = weight / ((height/100) * (height/100));
			System.out.println("Your BMi is:" + bmi);
			return bmi;
		}
		
	}
