package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Album_TypeFormat {
	public static void main(String[] args) {
			
			
			String name;
			
			try {
			Connection myConnection = DriverManager.getConnection("jdbc:mysql://sql7.freesqldatabase.com:3306/sql7622470", "sql7622470", "gkREcgyY8t");
			
			Statement mystatement = myConnection.createStatement();
			
			
			
			mystatement.executeUpdate("INSERT INTO Album_FormatType (ID_Album,ID_FormatType) VALUES (,)");
			
			System.out.println("Format introduit correctament");

		
		} catch (SQLException e) {
				
			e.printStackTrace();
		}
		
	}
}
