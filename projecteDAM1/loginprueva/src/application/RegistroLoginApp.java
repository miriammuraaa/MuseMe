package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;

public class RegistroLoginApp extends Application {
    private static final String DB_URL = "jdbc:mysql://sql7.freesqldatabase.com:3306/sql7622470";
    private static final String DB_User = "sql7622470";
    private static final String DB_Password = "gkREcgyY8t";

    private Connection connection;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Registro y Login");

        // Conectar a la base de datos
        connectToDatabase();

        // Crear los componentes de la interfaz de usuario
        Label registerLabel = new Label("Registro");
        Label NameLabel = new Label("Name:");
        TextField NameField = new TextField();
        Label LastNameLabel = new Label("Last Name:");
        TextField LastNameField = new TextField();
        Label EmailLabel = new Label("Email:");
        TextField EmailField = new TextField();
        Label PasswordLabel = new Label("Password:");
        PasswordField PasswordField = new PasswordField();
        Button registerButton = new Button("Registrarse");

        Label loginLabel = new Label("Iniciar Sesión");
        Label loginUserNameLabel = new Label("Usuario:");
        TextField loginUserNameField = new TextField();
        Label loginPasswordLabel = new Label("Contraseña:");
        PasswordField loginPasswordField = new PasswordField();
        Button loginButton = new Button("Iniciar Sesión");

        // Configurar los eventos de los botones
        registerButton.setOnAction(e -> registerUser(NameField.getText(), LastNameField.getText(),
                EmailField.getText(), PasswordField.getText()));
        loginButton.setOnAction(e -> loginUser(loginUserNameField.getText(), loginPasswordField.getText()));

        // Crear el diseño de la interfaz
        GridPane registerGrid = new GridPane();
        registerGrid.setHgap(10);
        registerGrid.setVgap(10);
        registerGrid.addRow(0, NameLabel, NameField);
        registerGrid.addRow(1, LastNameLabel, LastNameField);
        registerGrid.addRow(2, EmailLabel, EmailField);
        registerGrid.addRow(3, PasswordLabel, PasswordField);

        GridPane loginGrid = new GridPane();
        loginGrid.setHgap(10);
        loginGrid.setVgap(10);
        loginGrid.addRow(0, loginUserNameLabel, loginUserNameField);
        loginGrid.addRow(1, loginPasswordLabel, loginPasswordField);

        VBox registerVBox = new VBox(10, registerLabel, registerGrid, registerButton);
        registerVBox.setAlignment(Pos.CENTER);
        VBox loginVBox = new VBox(10, loginLabel, loginGrid, loginButton);
        loginVBox.setAlignment(Pos.CENTER);

        HBox root = new HBox(20, registerVBox, loginVBox);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        // Mostrar la escena
        Scene scene = new Scene(root, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void connectToDatabase() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_User, DB_Password);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            System.exit(1);
        }
    }

    private void registerUser(String Name, String LastName, String Email, String Password) {
        try {
            // Verificar si el usuario ya existe en la base de datos
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM User WHERE Email = ?");
            statement.setString(1, Email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                showAlert(Alert.AlertType.ERROR, "Error de Registro", "El usuario ya existe");
                return;
            }

            // Insertar el nuevo usuario en la base de datos
            statement = connection.prepareStatement("INSERT INTO User (Name, LastName, Email, Password) VALUES (?, ?, ?, ?)");
            statement.setString(1, Name);
            statement.setString(2, LastName);
            statement.setString(3, Email);
            statement.setString(4, Password);
            statement.executeUpdate();

            showAlert(Alert.AlertType.INFORMATION, "Registro Exitoso", "Usuario registrado exitosamente");
        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, "Error de Registro", "Error al registrar el usuario: " + e.getMessage());
        }
    }

    private void loginUser(String UserName, String Password) {
        try {
            // Verificar las credenciales del usuario en la base de datos
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM User WHERE Email = ? AND Password = ?");
            statement.setString(1, UserName);
            statement.setString(2, Password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                showAlert(Alert.AlertType.INFORMATION, "Inicio de Sesión Exitoso", "Inicio de sesión exitoso");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error de Inicio de Sesión", "Credenciales inválidas");
            }
        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, "Error de Inicio de Sesión", "Error al iniciar sesión: " + e.getMessage());
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
