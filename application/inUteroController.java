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
 * Controller class for the inUtero.fxml file.
 * 
 * This class manages the behavior and events of the inUtero view. It implements
 * the Initializable interface to initialize the view. The view displays an
 * image, buttons, and a table view. The buttons allow navigation to other
 * views, and the table view shows data.
 * 
 * @author Enric&Miriam
 * @version v1
 *
 */
public class inUteroController implements Initializable {
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
	 * Event listener for the log button. Loads the logview.fxml file and sets it as
	 * the scene. Sets the window title to "MuseME". Shows the primaryStage.
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
	 * Event listener for the home button. Loads the homePage.fxml file and sets it
	 * as the scene. Sets the window title to "MuseME". Shows the primaryStage.
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
	 * Event listener for the exit button. Closes the primaryStage.
	 *
	 * @param event The action event triggered by the button.
	 */
	@FXML
	public void actionExit(ActionEvent event) {
		Main.primaryStage.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		columName.setCellValueFactory(data -> data.getValue().get("Name"));
		columDuration.setCellValueFactory(data -> data.getValue().get("Duration"));
		// Fill the table with data using the MyMethods.fillTable method
		MyMethods.fillTable("In Utero", Tablageneral);

	}
}
