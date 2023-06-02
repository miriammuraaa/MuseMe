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
 * Controller class for the Bad.fxml file. Implements the Initializable
 * interface.
 * 
 * @author Enric&Miriam
 * @version v1
 *
 */
public class BadController implements Initializable {
	@FXML
	private VBox panelFormSignIn;
	@FXML
	private ImageView banerMichael;
	@FXML
	private ImageView OffTheWall;
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

	/**
	 * Initializes the controller. Sets the cell value factories for the
	 * TableColumns. Fills the table with data using MyMethods.fillTable() method.
	 *
	 * @param arg0 The URL, not used in this case.
	 * @param arg1 The ResourceBundle, not used in this case.
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Asignar los tipos de datos a las columnas
		columName.setCellValueFactory(data -> data.getValue().get("Name"));
		columDuration.setCellValueFactory(data -> data.getValue().get("Duration"));

		MyMethods.fillTable("Bad", Tablageneral);
	}
}
