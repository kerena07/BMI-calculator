package BMI;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BMIServerInterfaceClient extends Application {
	private BMIServerInterface bmiServerInterface;
	private TextField tf_height = new TextField();
	private TextField tf_weight = new TextField();
	private TextField tf_BMI= new TextField();
	private Button bt_calculate = new Button("Calculate");
	GridPane gPane = new GridPane();
	HBox hBox = new HBox();
	VBox vBox = new VBox();
	@Override
	public void start(Stage arg0) throws Exception {
		gPane.add(new Label("Height: "), 0, 0);
		gPane.add(tf_height, 1, 0);
		gPane.add(new Label("Weight: "), 0, 1);
		gPane.add(tf_weight, 1, 1);
		gPane.add(new Label("BMI: "), 0,2);
		gPane.add(tf_BMI, 1, 2);
		gPane.add(bt_calculate, 1, 3);
		
		tf_BMI.setEditable(false);
		
		gPane.setPadding(new Insets(20));
		vBox.getChildren().add(gPane);
		vBox.setPadding(new Insets(20));
		vBox.setAlignment(Pos.CENTER);
		
		arg0.setScene(new Scene(vBox));
		arg0.show();
		
		initializeRMI();
		bt_calculate.setOnAction(e -> setBMI());
	}
	
	public static void main(String[] args) {
	    launch(args);
	  }
	
	public double getHeight() {
		return Double.parseDouble(tf_height.getText().trim());
	}
	
	public double getWeight() {
		return Double.parseDouble(tf_weight.getText().trim());
	}
	
	protected void initializeRMI() {
		String hoString = "";
		try {
			Registry registry = LocateRegistry.getRegistry(hoString);
			bmiServerInterface = (BMIServerInterface) registry.lookup("bmiserverinterface");
			System.out.println("Server object " + bmiServerInterface + " found");
			
		} catch (Exception e) {
			System.out.println(e);
			
		}
	}
	
	protected void setBMI(){
		double bmi = 0;
		try {
			bmi = bmiServerInterface.getBMI(getHeight(), getWeight());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		tf_BMI.setText(String.valueOf(bmi));
	}
}

