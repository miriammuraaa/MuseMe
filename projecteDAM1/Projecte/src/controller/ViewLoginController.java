package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.PasswordField;

public class ViewLoginController implements Initializable{

	@FXML
	private TextField textUser;
	
	@FXML
	private PasswordField textPassword;
	
	@FXML
	private Button buttonSignUp;
	
	@FXML
	private void eventKey(KeyEvent event) {
		
		Object evt=event.getSource();
		
		if(evt.equals(textUser)){
			
			
			
		}else if (evt.equals(textPassword)) {
			
			
		}
		
	}
	
	@FXML
	private void eventAction(ActionEvent event) {
		
	}
	
	public void initialize(URL url, ResourceBundle rb) {
	
		
	}

}
