package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Artist_Song {

	public static void main(String[] args) {
		
		
		String name;
		
		try {
		Connection myConnection = DriverManager.getConnection("jdbc:mysql://sql7.freesqldatabase.com:3306/sql7622470", "sql7622470", "gkREcgyY8t");
		
		Statement mystatement = myConnection.createStatement();
		
		
		
		mystatement.executeUpdate("INSERT INTO Artists_Songs (ID_Song,ID_Artist) VALUES (28,4)");
		
		System.out.println("Artista afegit a la canço introduit correctament");

	
	} catch (SQLException e) {
			
		e.printStackTrace();
	}
	
}

}
