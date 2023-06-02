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

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * The controller class for the "OffTheWall" view.
 * 
 * @author Enric&Miriam
 * @version v1
 *
 */
public class OffTheWallController implements Initializable {
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
	 * Event listener for the "btnLog" button's action.
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
	 * Event listener for the "btnHome" button's action.
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
	 * Event listener for the "btnExit" button's action.
	 *
	 * @param event The action event.
	 */
	@FXML
	public void actionExit(ActionEvent event) {
		Main.primaryStage.close();
	}

	/**
	 * Initializes the controller.
	 *
	 * @param arg0 The URL of the location used to resolve relative paths.
	 * @param arg1 The resource bundle containing localized objects.
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Asignar los tipos de datos a las columnas
		columName.setCellValueFactory(data -> data.getValue().get("Name"));
		columDuration.setCellValueFactory(data -> data.getValue().get("Duration"));

		MyMethods.fillTable("Off The Wall", Tablageneral);
	}
}
