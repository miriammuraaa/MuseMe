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
 * Controller class for the album page of Michael Jackson.
 * 
 * @author Enric&Miriam
 * @version v1
 *
 */
public class albumPageMichaelController {
	@FXML
	private VBox panelFormSignIn;
	@FXML
	private ImageView banerMichael;
	@FXML
	private Button btnThriller;
	@FXML
	private Button btnOffTheWall;
	@FXML
	private Button btnBad;
	@FXML
	private Button btnLog;
	@FXML
	private Button btnHome;
	@FXML
	private Button btnExit;

	// Event Listener on Button[#btnThriller].onAction
	/**
	 * Event handler for the "Thriller" button. Loads the "Thriller.fxml" view when
	 * the button is clicked.
	 * 
	 * @param event The event object representing the button click.
	 */
	@FXML
	public void actionThriller(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Thriller.fxml"));
			Scene scene = new Scene(root);
			Main.primaryStage.setTitle("MuseME");
			Main.primaryStage.setScene(scene);
			Main.primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Event Listener on Button[#btnOffTheWall].onAction
	/**
	 * Event handler for the "Off The Wall" button. Loads the "OffTheWall.fxml" view
	 * when the button is clicked.
	 * 
	 * @param event The event object representing the button click.
	 */
	@FXML
	public void actionOffTheWall(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("OffTheWall.fxml"));
			Scene scene = new Scene(root);
			Main.primaryStage.setTitle("MuseME");
			Main.primaryStage.setScene(scene);
			Main.primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Event Listener on Button[#btnBad].onAction
	/**
	 * Event handler for the "Bad" button. Loads the "Bad.fxml" view when the button
	 * is clicked.
	 * 
	 * @param event The event object representing the button click.
	 */
	@FXML
	public void actionBad(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Bad.fxml"));
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
	 * Event handler for the "Log" button. Loads the "logview.fxml" view when the
	 * button is clicked.
	 * 
	 * @param event The event object representing the button click.
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
	 * Event handler for the "Home" button. Loads the "homePage.fxml" view when the
	 * button is clicked.
	 * 
	 * @param event The event object representing the button click.
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
	 * Event handler for the "Exit" button. Closes the application when the button
	 * is clicked.
	 * 
	 * @param event The event object representing the button click.
	 */
	@FXML
	public void actionExit(ActionEvent event) {
		Main.primaryStage.close();
	}
}
