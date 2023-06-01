package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;

import javafx.scene.control.PasswordField;

import javafx.scene.layout.VBox;

public class loginController {
	@FXML
	private VBox panelFormSignIn;
	@FXML
	private TextField txtEmail;
	@FXML
	private PasswordField txtPassword;
	@FXML
	private TextField txtPasswordSignInMask;
	@FXML
	private Button btnRegister;
	@FXML
	private Button btnLogin;

	// Event Listener on Button[#btnRegister].onAction
	@FXML
	public void actionRegister(ActionEvent event) {
		try {
			 FXMLLoader loader = new FXMLLoader(getClass().getResource("register.fxml"));
	         Parent root = loader.load();
	         
	         Main.primaryStage.setTitle("Sign Up ");
	         Main.primaryStage.setScene(new Scene(root));
	         Main.primaryStage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	// Event Listener on Button[#btnLogin].onAction
	@FXML
	public void actionLogin(ActionEvent event) {
		String email= txtEmail.getText();
		String password= txtPassword.getText();
		if(!MyMethods.NotAlreadyRegister(email) && MyMethods.CheckLogin(password, email) ) {
			
			 LocalDateTime now = LocalDateTime.now();
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		        String fechaHoraActual = now.format(formatter);
		        
	            try {
	            	 
	    	        String path = "G:\\Projecte\\log.txt";
	    	        FileWriter fileWriter = new FileWriter(path, true);
	    	        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	                
	                bufferedWriter.write("Email: " + email);
	                bufferedWriter.newLine();
	                bufferedWriter.write("Date and Time: " + fechaHoraActual);
	                bufferedWriter.newLine();
	                bufferedWriter.newLine();
	                
	                bufferedWriter.close();
	                System.out.println("Se ha registrado la informaci�n en el archivo log.txt");
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
			
		}
	}


