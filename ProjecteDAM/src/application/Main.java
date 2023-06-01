package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;



public class Main extends Application {
	    public  static Stage primaryStage;
	  
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		   
        
		this.primaryStage = primaryStage;
		try {
			Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
			Scene scene=new Scene(root);
			primaryStage.setScene(scene);
			
//			   Pane paneRoot = new Pane();
//		        var scene2 = new Scene(paneRoot, 640, 480);
//	        Image imagen = new Image(getClass().getResourceAsStream("/image/logo.png"));
//	        ImageView imgView = new ImageView(imagen);
//	        paneRoot.getChildren().add(imgView);
//			ImageView logo = new ImageView("images/logo.png");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

