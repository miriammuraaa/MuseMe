package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;

import javafx.scene.image.ImageView;

import javafx.scene.layout.VBox;

/**
 * 
 * Controller class for the albumPageNirvana.fxml file.
 * 
 * @author Enric&Miriam
 * @version v1
 *
 */
public class albumPageNirvanaController {
	@FXML
	private VBox panelFormSignIn;
	@FXML
	private ImageView banerDrake;
	@FXML
	private Button btnNevermind;
	@FXML
	private Button btnInUtero;
	@FXML
	private Button btnBleach;
	@FXML
	private Button btnLog;
	@FXML
	private Button btnHome;
	@FXML
	private Button btnExit;

	// Event Listener on Button[#btnNevermind].onAction
	/**
	 * Event listener for the btnNevermind button. Loads the Nevermind.fxml file and
	 * sets it as the scene. Sets the window title to "MuseME". Shows the
	 * primaryStage.
	 *
	 * @param event The action event triggered by the button.
	 */
	@FXML
	public void actionNevermind(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Nevermind.fxml"));
			Scene scene = new Scene(root);
			Main.primaryStage.setTitle("MuseME");
			Main.primaryStage.setScene(scene);
			Main.primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Event Listener on Button[#btnInUtero].onAction
	/**
	 * Event listener for the btnInUtero button. Loads the inUtero.fxml file and
	 * sets it as the scene. Sets the window title to "MuseME". Shows the
	 * primaryStage.
	 *
	 * @param event The action event triggered by the button.
	 */
	@FXML
	public void actionInUtero(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("inUtero.fxml"));
			Scene scene = new Scene(root);
			Main.primaryStage.setTitle("MuseME");
			Main.primaryStage.setScene(scene);
			Main.primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Event Listener on Button[#btnBleach].onAction
	/**
	 * Event listener for the btnBleach button. Loads the Bleach.fxml file and sets
	 * it as the scene. Sets the window title to "MuseME". Shows the primaryStage.
	 *
	 * @param event The action event triggered by the button.
	 */
	@FXML
	public void actionBleach(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Bleach.fxml"));
			Scene scene = new Scene(root);
			Main.primaryStage.setTitle("MuseME");
			Main.primaryStage.setScene(scene);
			Main.primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Event Listener on Button[#btnLog].onAction
	/**
	 * Event listener for the btnLog button. Loads the logview.fxml file and sets it
	 * as the scene. Sets the window title to "MuseME". Shows the primaryStage.
	 *
	 * @param event The action event triggered by the button.
	 */
	@FXML
	public void actionLog(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("logview.fxml"));
			Scene scene = new Scene(root);
			Main.primaryStage.setTitle("MuseME");
			Main.primaryStage.setScene(scene);
			Main.primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Event Listener on Button[#btnHome].onAction
	/**
	 * Event listener for the btnHome button. Loads the homePage.fxml file and sets
	 * it as the scene. Sets the window title to "MuseME". Shows the primaryStage.
	 *
	 * @param event The action event triggered by the button.
	 */
	@FXML
	public void actionHome(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
			Scene scene = new Scene(root);
			Main.primaryStage.setTitle("MuseME");
			Main.primaryStage.setScene(scene);
			Main.primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Event Listener on Button[#btnExit].onAction
	/**
	 * Event listener for the btnExit button. Closes the primaryStage.
	 *
	 * @param event The action event triggered by the button.
	 */
	@FXML
	public void actionExit(ActionEvent event) {
		Main.primaryStage.close();
	}
}
