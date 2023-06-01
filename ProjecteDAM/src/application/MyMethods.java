package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Pattern;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

public class MyMethods {
	


	public static boolean CheckName(String nombre, String apellido) {
	
		if(!nombre.matches("^[a-zA-Z]+$") || !apellido.matches("^[a-zA-Z]+$")) {
	 		
	 		 Alert alert = new Alert(Alert.AlertType.ERROR);
	         alert.setTitle("Alert");
	         alert.setHeaderText("Invalid name or last name");
	         alert.setContentText("Be careful! A name or last name can't have numbers or special characters. ");
	         alert.showAndWait();
	         
	         return false;
	 	}else {
	 		return true;
	 	}
	}
	public static boolean CheckEmail(String email) {
		if(email.contains("@") && email.contains(".") && email.indexOf("@") < email.lastIndexOf(".")) {
	 		
	 		
	         
	         return true;
	 	}else {
	 		 Alert alert = new Alert(Alert.AlertType.ERROR);
	         alert.setTitle("Alert");
	         alert.setHeaderText("Invalid email");
	         alert.setContentText("An email must contain '@' and '.'.");
	         alert.showAndWait();
	 		return false;
	 	}

	}
	
	public static boolean CheckPassword(String password) {
        if (password.length() < 8|| !Pattern.compile("[A-Z]").matcher(password).find()|| !Pattern.compile("[0-9]").matcher(password).find()) {
           
        	 Alert alert = new Alert(Alert.AlertType.ERROR);
	         alert.setTitle("Alert");
	         alert.setHeaderText("Invalid password");
	         alert.setContentText("At least a number, a capital letter and 8 characters");
	         alert.showAndWait();
        	
        	return false;
        }else {
        	
        	 return true;
        }

       
    } 
	
	public static boolean CheckEqualPassword(String password, String password2) {
		if(!password.equals(password2)) {
			 Alert alert = new Alert(Alert.AlertType.ERROR);
	         alert.setTitle("Alert");
	         alert.setHeaderText("Password doesn't match ");
	         alert.setContentText("Check if the password are the same");
	         alert.showAndWait();
			
			return false;
			
		}else {
			return true;	
		}
        
    }
	
	public static boolean AlreadyRegister(String email) {
		
		try {
			Connection myConnection = DriverManager.getConnection("jdbc:mysql://sql7.freesqldatabase.com:3306/sql7622470", "sql7622470", "gkREcgyY8t");
			
			Statement mystatement = myConnection.createStatement();
			
			ResultSet resultSet=mystatement.executeQuery("SELECT count(*) FROM User WHERE Email='"+email+"'");
			
			resultSet.next();
            int count = resultSet.getInt(1);
			
			if(count>0) {
				 Alert alert = new Alert(Alert.AlertType.INFORMATION);
		         alert.setTitle("INFO");
		         alert.setHeaderText("Email already registred");
		         alert.setContentText("Sign in!!");
		         alert.showAndWait();
		         
				System.out.println("usuari ja registrat");
				
				return true;
				
			}else {
				
				
				return false;	
			}
			
		
		} catch (Exception e ) {
			
			return false;	
			
		}
		
		
        
    }
	
public static boolean CheckLogin(String password,String email) {
		
		try {
			Connection myConnection = DriverManager.getConnection("jdbc:mysql://sql7.freesqldatabase.com:3306/sql7622470", "sql7622470", "gkREcgyY8t");
			
			Statement mystatement = myConnection.createStatement();
			
			ResultSet resultSet=mystatement.executeQuery("SELECT Password FROM User WHERE Email='"+email+"'");
			
			resultSet.next(); 
			 String passworduser = resultSet.getString("Password");
				 
			if(!passworduser.equals(password)) {
				
				 Alert alert = new Alert(Alert.AlertType.ERROR);
		         alert.setTitle("Alert");
		         alert.setHeaderText("Invalid password");
		         alert.setContentText("Check if you write correctly your password");
		         alert.showAndWait();
				return false;
			}else {
				
				return true;
			}
       
			
			
			
		
		} catch (Exception e ) {
			
			return false;	
			
		}
		
		
        
    }

public static boolean NotAlreadyRegister(String email) {
	
	try {
		Connection myConnection = DriverManager.getConnection("jdbc:mysql://sql7.freesqldatabase.com:3306/sql7622470", "sql7622470", "gkREcgyY8t");
		
		Statement mystatement = myConnection.createStatement();
		
		ResultSet resultSet=mystatement.executeQuery("SELECT count(*) FROM User WHERE Email='"+email+"'");
		
		resultSet.next();
        int count = resultSet.getInt(1);
		
		if(count<0) {
			 Alert alert = new Alert(Alert.AlertType.INFORMATION);
	         alert.setTitle("INFO");
	         alert.setHeaderText("Email isn´t registred");
	         alert.setContentText("Sign up!!");
	         alert.showAndWait();
	         
			System.out.println("usuari no registrat");
			
			return true;
			
		}else {
			
			
			return false;	
		}
		
	
	} catch (Exception e ) {
		
		return false;	
		
	}
	
	
    
}
	
}
