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
 * Controller class for the albumPageDrake.fxml view
 * 
 * @author Enric&Miriam
 * @version v1
 *
 */
public class albumPageDrakeController {
	@FXML
	private VBox panelFormSignIn;
	@FXML
	private ImageView banerDrake;
	@FXML
	private Button btnHonestlyNeverMind;
	@FXML
	private Button btnTooLate;
	@FXML
	private Button btnNothingWasSame;
	@FXML
	private Button btnLog;
	@FXML
	private Button btnHome;
	@FXML
	private Button btnExit;

	// Event Listener on Button[#btnHonestlyNeverMind].onAction
	/**
	 * Event handler for the btnHonestlyNeverMind button. Loads the
	 * HonestlyNeverMind.fxml view when the button is clicked.
	 * 
	 * @param event The action event triggered by the button click.
	 */
	@FXML
	public void actionHonestlyNeverMind(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("HonestlyNeverMind.fxml"));
			Scene scene = new Scene(root);
			Main.primaryStage.setTitle("MuseME");
			Main.primaryStage.setScene(scene);
			Main.primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Event Listener on Button[#btnTooLate].onAction
	/**
	 * Event handler for the btnTooLate button. Loads the TooLate.fxml view when the
	 * button is clicked.
	 * 
	 * @param event The action event triggered by the button click.
	 */
	@FXML
	public void actionTooLate(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("TooLate.fxml"));
			Scene scene = new Scene(root);
			Main.primaryStage.setTitle("MuseME");
			Main.primaryStage.setScene(scene);
			Main.primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Event Listener on Button[#btnNothingWasSame].onAction
	/**
	 * Event handler for the btnNothingWasSame button. Loads the
	 * NothingWasTheSame.fxml view when the button is clicked.
	 * 
	 * @param event The action event triggered by the button click.
	 */
	@FXML
	public void actionNothingWasSame(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("NothingWasTheSame.fxml"));
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
	 * Event handler for the btnLog button. Loads the logview.fxml view when the
	 * button is clicked.
	 * 
	 * @param event The action event triggered by the button click.
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
	 * Event handler for the btnHome button. Loads the homePage.fxml view when the
	 * button is clicked.
	 * 
	 * @param event The action event triggered by the button click.
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
	 * Event handler for the btnExit button. Closes the application's primary stage
	 * when the button is clicked.
	 * 
	 * @param event The action event triggered by the button click.
	 */
	@FXML
	public void actionExit(ActionEvent event) {
		Main.primaryStage.close();
	}
}
