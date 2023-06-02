package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;

import javafx.scene.image.ImageView;

import javafx.scene.layout.VBox;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

/**
 * Controller class for the Nevermind view.
 *
 * This class handles the initialization and event handling for the Nevermind
 * view.
 * 
 * @author Enric&Miriam
 * @version v1
 *
 */
public class NevermindController implements Initializable {
	@FXML
	private VBox panelFormSignIn;
	@FXML
	private ImageView banerDrake;
	@FXML
	private TableView<Map<String, ObservableValue<String>>> Tablageneral;
	@FXML
	private TableColumn<Map<String, ObservableValue<String>>, String> columName;
	@FXML
	private TableColumn<Map<String, ObservableValue<String>>, String> columDuration;
	@FXML
	private Button btnLog;
	@FXML
	private Button btnHome;
	@FXML
	private Button btnExit;

	// Event Listener on Button[#btnLog].onAction
	/**
	 * Event handler for the "Log" button.
	 *
	 * Loads the logview.fxml and switches to the log view.
	 *
	 * @param event The action event.
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
	 * Event handler for the "Home" button.
	 *
	 * Loads the homePage.fxml and switches to the home page view.
	 *
	 * @param event The action event.
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
	 * Event handler for the "Exit" button.
	 *
	 * Closes the application.
	 *
	 * @param event The action event.
	 */
	@FXML
	public void actionExit(ActionEvent event) {
		Main.primaryStage.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Set cell value factories for the table columns
		columName.setCellValueFactory(data -> data.getValue().get("Name"));
		columDuration.setCellValueFactory(data -> data.getValue().get("Duration"));
		 // Fill the table with data from the "Nevermind" album
		MyMethods.fillTable("Nevermind", Tablageneral);

	}
}
