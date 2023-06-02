package application;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.control.Alert;
import javafx.scene.control.TableView;

/**
 * Utility class containing various methods used in the application.
 *
 * This class provides methods for data validation, database operations, and
 * filling table views.
 * 
 * @author Enric&Miriam
 * @version v1
 *
 */
public class MyMethods {

	/**
	 * Checks if the provided name and last name only contain alphabetic characters.
	 *
	 * @param nombre   The name to be checked.
	 * @param apellido The last name to be checked.
	 * @return True if the name and last name are valid, false otherwise.
	 */
	public static boolean CheckName(String nombre, String apellido) {

		if (!nombre.matches("^[a-zA-Z]+$") || !apellido.matches("^[a-zA-Z]+$")) {

			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Alert");
			alert.setHeaderText("Invalid name or last name");
			alert.setContentText("Be careful! A name or last name can't have numbers or special characters. ");
			alert.showAndWait();

			return false;
		} else {
			return true;
		}
	}

	/**
	 * Checks if the provided email is in a valid format.
	 *
	 * @param email The email to be checked.
	 * @return True if the email is valid, false otherwise.
	 */
	public static boolean CheckEmail(String email) {
		if (email.contains("@") && email.contains(".") && email.indexOf("@") < email.lastIndexOf(".")) {

			return true;
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Alert");
			alert.setHeaderText("Invalid email");
			alert.setContentText("An email must contain '@' and '.'.");
			alert.showAndWait();
			return false;
		}

	}

	/**
	 * Checks if the provided password meets the required criteria.
	 *
	 * @param password The password to be checked.
	 * @return True if the password is valid, false otherwise.
	 */
	public static boolean CheckPassword(String password) {
		if (password.length() < 8 || !Pattern.compile("[A-Z]").matcher(password).find()
				|| !Pattern.compile("[0-9]").matcher(password).find()) {

			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Alert");
			alert.setHeaderText("Invalid password");
			alert.setContentText("At least a number, a capital letter and 8 characters");
			alert.showAndWait();

			return false;
		} else {

			return true;
		}

	}

	/**
	 * Checks if two passwords match.
	 *
	 * @param password  The first password.
	 * @param password2 The second password.
	 * @return True if the passwords match, false otherwise.
	 */
	public static boolean CheckEqualPassword(String password, String password2) {
		if (!password.equals(password2)) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Alert");
			alert.setHeaderText("Password doesn't match ");
			alert.setContentText("Check if the password are the same");
			alert.showAndWait();

			return false;

		} else {
			return true;
		}

	}

	/**
	 * Checks if an email is already registered in the database.
	 *
	 * @param email The email to be checked.
	 * @return True if the email is already registered, false otherwise.
	 */
	public static boolean AlreadyRegister(String email) {

		try {
			Connection myConnection = DriverManager
					.getConnection("jdbc:mysql://sql7.freesqldatabase.com:3306/sql7622470", "sql7622470", "gkREcgyY8t");

			Statement mystatement = myConnection.createStatement();

			ResultSet resultSet = mystatement.executeQuery("SELECT count(*) FROM User WHERE Email='" + email + "'");

			resultSet.next();
			int count = resultSet.getInt(1);

			if (count > 0) {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("INFO");
				alert.setHeaderText("Email already registred");
				alert.setContentText("Sign in!!");
				alert.showAndWait();

				System.out.println("usuari ja registrat");

				return true;

			} else {

				return false;
			}

		} catch (Exception e) {

			return false;

		}

	}

	/**
	 * Checks if the provided password matches the one associated with the given
	 * email in the database.
	 *
	 * @param password The password to be checked.
	 * @param email    The email associated with the password.
	 * @return True if the password is valid, false otherwise.
	 */
	public static boolean CheckLogin(String password, String email) {

		try {
			Connection myConnection = DriverManager
					.getConnection("jdbc:mysql://sql7.freesqldatabase.com:3306/sql7622470", "sql7622470", "gkREcgyY8t");

			Statement mystatement = myConnection.createStatement();

			ResultSet resultSet = mystatement.executeQuery("SELECT Password FROM User WHERE Email='" + email + "'");

			resultSet.next();
			String passworduser = resultSet.getString("Password");

			if (!passworduser.equals(password)) {

				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Alert");
				alert.setHeaderText("Invalid password");
				alert.setContentText("Check if you write correctly your password");
				alert.showAndWait();
				return false;
			} else {

				return true;
			}

		} catch (Exception e) {

			return false;

		}

	}

	/**
	 * Checks if an email is not registered in the database.
	 *
	 * @param email The email to be checked.
	 * @return True if the email is not registered, false otherwise.
	 */
	public static boolean NotAlreadyRegister(String email) {

		try {
			Connection myConnection = DriverManager
					.getConnection("jdbc:mysql://sql7.freesqldatabase.com:3306/sql7622470", "sql7622470", "gkREcgyY8t");

			Statement mystatement = myConnection.createStatement();

			ResultSet resultSet = mystatement.executeQuery("SELECT count(*) FROM User WHERE Email='" + email + "'");

			resultSet.next();
			int count = resultSet.getInt(1);

			if (count < 1) {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("INFO");
				alert.setHeaderText("Email isn´t registred");
				alert.setContentText("Sign up!!");
				alert.showAndWait();

				System.out.println("usuari no registrat");

				return true;

			} else {

				return false;
			}

		} catch (Exception e) {

			return false;

		}

	}

	/**
	 * Fills a table view with data from the database.
	 *
	 * @param Album        The album name to retrieve the songs from.
	 * @param Tablageneral The table view to be filled.
	 */
	public static void fillTable(String Album, TableView<Map<String, ObservableValue<String>>> Tablageneral) {
		ObservableList<Map<String, ObservableValue<String>>> data = FXCollections.observableArrayList();

		try {
			Connection myConnection = DriverManager
					.getConnection("jdbc:mysql://sql7.freesqldatabase.com:3306/sql7622470", "sql7622470", "gkREcgyY8t");

			PreparedStatement mystatement = myConnection
					.prepareStatement("SELECT * FROM Songs WHERE FK_IDAlbum=(SELECT ID_Album FROM Album WHERE Name=?)");
			mystatement.setString(1, Album);
			ResultSet resultSet = mystatement.executeQuery();

			while (resultSet.next()) {
				Map<String, ObservableValue<String>> row = new HashMap<>();
				row.put("Name", new SimpleStringProperty(resultSet.getString("Name")));
				row.put("Duration", new SimpleStringProperty(resultSet.getString("Duration")));
				data.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Tablageneral.setItems(data);
	}

}
