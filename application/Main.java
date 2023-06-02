package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

/**
 * The main class for the application.
 */
public class Main extends Application {
	public static Stage primaryStage;

	/**
	 * The entry point for the JavaFX application.
	 *
	 * @param primaryStage The primary stage for the application.
	 * @throws Exception if an error occurs during the application start.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		// Set application icon
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/logo.png")));

		Main.primaryStage = primaryStage;
		try {
			Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
			Scene scene = new Scene(root);
			Main.primaryStage.setTitle("MuseME");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * The main method, which launches the JavaFX application.
	 *
	 * @param args The command line arguments.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
