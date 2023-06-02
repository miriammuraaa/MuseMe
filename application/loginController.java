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

/**
 * Controller class for the login.fxml file.
 *
 * This class manages the behavior and events of the login view. It handles user
 * registration and login functionality.
 * 
 * @author Enric&Miriam
 * @version v1
 *
 */
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
	/**
	 * Event listener for the register button. Loads the register.fxml file and sets
	 * it as the scene. Sets the window title to "Sign Up". Shows the primaryStage.
	 *
	 * @param event The action event triggered by the button.
	 */
	@FXML
	public void actionRegister(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("register.fxml"));
			Parent root = loader.load();

			Main.primaryStage.setTitle("Sign Up ");
			Main.primaryStage.setScene(new Scene(root));
			Main.primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Event Listener on Button[#btnLogin].onAction
	/**
	 * Event listener for the login button. Retrieves the email and password from
	 * the input fields. Checks if the email is valid, not already registered, and
	 * the login is successful. If the conditions are met, logs the user information
	 * to a log.txt file and navigates to the homePage view.
	 *
	 * @param event The action event triggered by the button.
	 */
	@FXML
	public void actionLogin(ActionEvent event) {
		String email = txtEmail.getText();
		String password = txtPassword.getText();
		if (MyMethods.CheckEmail(email) && !MyMethods.NotAlreadyRegister(email)
				&& MyMethods.CheckLogin(password, email)) {

			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String fechaHoraActual = now.format(formatter);

			try {

				String path = "D:\\Projecte\\log.txt";
				FileWriter fileWriter = new FileWriter(path, true);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

				bufferedWriter.write("Email: " + email);
				bufferedWriter.newLine();
				bufferedWriter.write("Date and Time: " + fechaHoraActual);
				bufferedWriter.newLine();
				bufferedWriter.newLine();

				bufferedWriter.close();
				System.out.println("Se ha registrado la informaci�n en el archivo log.txt");

				FXMLLoader loader = new FXMLLoader(getClass().getResource("homePage.fxml"));
				Parent root = loader.load();

				Main.primaryStage.setTitle("Home Page");
				Main.primaryStage.setScene(new Scene(root));
				Main.primaryStage.show();
				System.out.println("tete");

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
