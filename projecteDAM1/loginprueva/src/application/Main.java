package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    private Database database; // Clase separada para la base de datos

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Registro");

        // Crear un panel GridPane
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        // Agregar controles al panel
        Label NameLabel = new Label("Name:");
        gridPane.add(NameLabel, 0, 0);
        TextField NameTextField = new TextField();
        gridPane.add(NameTextField, 1, 0);

        Label LastNameLabel = new Label("Last Name:");
        gridPane.add(LastNameLabel, 0, 1);
        TextField LastNameTextField = new TextField();
        gridPane.add(LastNameTextField, 1, 1);

        Label EmailLabel = new Label("Email:");
        gridPane.add(EmailLabel, 0, 2);
        TextField EmailTextField = new TextField();
        gridPane.add(EmailTextField, 1, 2);

        Label PasswordLabel = new Label("Password:");
        gridPane.add(PasswordLabel, 0, 3);
        PasswordField PasswordField = new PasswordField();
        gridPane.add(PasswordField, 1, 3);

        Button loginButton = new Button("Login");
        gridPane.add(loginButton, 1, 4);
        loginButton.setOnAction(e -> {
            String Name = NameTextField.getText();
            String LastName = LastNameTextField.getText();
            String Email = EmailTextField.getText();
            String Password = PasswordField.getText();

            // Verificar el inicio de sesión en la base de datos
            if (database.checkCredentials(Name, LastName, Email, Password)) {
                System.out.println("Inicio de sesión exitoso");
                // Realizar acciones adicionales después de un inicio de sesión exitoso
            } else {
                showAlert(Alert.AlertType.ERROR, "Error de inicio de sesión",
                        "El usuario o la contraseña son incorrectos.");
            }
        });

        Button registerButton = new Button("Register");
        gridPane.add(registerButton, 1, 5);
        registerButton.setOnAction(e -> {
            // Mostrar ventana de registro
            showRegistrationWindow();
        });

        // Crear escena y mostrarla en la ventana
        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Método para mostrar una ventana de alerta
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Método para mostrar la ventana de registro
    private void showRegistrationWindow() {
        // Implementar la lógica para mostrar la ventana de registro
    }

    public static void main(String[] args) {
        launch(args);
    }
}
