package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

/**
 * Controller class for the logview.fxml file.
 * 
 * @author Enric&Miriam
 * @version v1
 *
 */
public class logviewController implements Initializable {
	@FXML
	private TableView<String> userLogs;
	@FXML
	private TableColumn<String, String> IdLogs;
	@FXML
	private Button btnSearch;
	@FXML
	private Button btnHome;
	@FXML
	private Button btnExit;

	/**
	 * Event handler for the search button.
	 *
	 * @param event The action event triggered by the button.
	 */
	@FXML
	public void actionSearch(ActionEvent event) {
		// TODO: Implementar la lógica de búsqueda
	}

	/**
	 * Event handler for the home button.
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

	/**
	 * Event handler for the exit button.
	 *
	 * @param event The action event triggered by the button.
	 * 
	 */
	@FXML
	public void actionExit(ActionEvent event) {
		Main.primaryStage.close();
	}

	/**
	 * Initializes the controller.
	 *
	 * @param arg0 The URL used to resolve relative paths.
	 * @param arg1 The resource bundle to be used for localization.
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		IdLogs.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));

		String logFilePath = "log.txt";
		ObservableList<String> logData = readLogFile(logFilePath);
		userLogs.setItems(logData);
	}

	/**
	 * Reads the log file and returns the data as an ObservableList of strings.
	 *
	 * @param logFilePath The path to the log file.
	 * @return The ObservableList containing the log data.
	 */
	private ObservableList<String> readLogFile(String logFilePath) {
		ObservableList<String> logData = FXCollections.observableArrayList();

		try (BufferedReader reader = new BufferedReader(new FileReader(logFilePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				logData.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return logData;
	}
}