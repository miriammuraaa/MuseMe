package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javafx.event.ActionEvent;

import javafx.scene.control.PasswordField;

import javafx.scene.layout.VBox;

public class registerController {
	@FXML
	private VBox panelFormsSignUp;
	@FXML
	private TextField txtName;
	@FXML
	private TextField txtLastname;
	@FXML
	private TextField txtEmail;
	@FXML
	private PasswordField txtPassword;
	@FXML
	private PasswordField txtPassword2;
	@FXML
	private Button btnRegister;

	// Event Listener on Button[#btnRegister].onAction
	@FXML
	public void actionRegister(ActionEvent event) {


		String nombre= txtName.getText();
		String apellido= txtLastname.getText();
		String email= txtEmail.getText();
		String password= txtPassword.getText();
		String password2= txtPassword2.getText();
		
		if(MyMethods.AlreadyRegister(email)) {
			try {
				  FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
		            Parent root = loader.load();
		            
		            Main.primaryStage.setTitle("Sign Up ");
		            Main.primaryStage.setScene(new Scene(root));
		            Main.primaryStage.show();
			}catch(Exception e) {
				
				
			}
			
		}else if(!MyMethods.CheckName(nombre,apellido)||!MyMethods.CheckEmail(email)||!MyMethods.CheckEqualPassword(password, password2)||!MyMethods.CheckPassword(password)) {
				
			}else {
				try {
					
					
					Connection myConnection = DriverManager.getConnection("jdbc:mysql://sql7.freesqldatabase.com:3306/sql7622470", "sql7622470", "gkREcgyY8t");
					
					Statement mystatement = myConnection.createStatement();
					
					mystatement.executeUpdate("INSERT INTO User (Name,LastName,Password,Email) VALUES ('"+nombre+"','"+apellido+"','"+password+"','"+email+"')");
					
					System.out.println("usuari introduit correctament");
					
					
					  FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
			            Parent root = loader.load();
			            
			            Main.primaryStage.setTitle("Sign Up ");
			            Main.primaryStage.setScene(new Scene(root));
			            Main.primaryStage.show();
				
				} catch (Exception e ) {
						
					e.printStackTrace();
				}
			}
			
		}
		
		
	
		
	}

