package project;

import java.sql.*;

public class tete {
	public static void main(String[] args) {
		
		String typeformat="Vinil";
		try {
			Connection myConnection = DriverManager.getConnection("jdbc:mysql://sql7.freesqldatabase.com:3306/sql7622470", "sql7622470", "gkREcgyY8t");
		
			Statement mystatement = myConnection.createStatement();
			
			
			
			mystatement.executeUpdate("INSERT INTO Album (Name,LaunchDate,Price,FK_IDartist) VALUES ('"+typeformat+"')");
			
			System.out.println("Format introduit correctament");
//			
//			while(myResultSet.next()) {
//				 String jobTitle = myResultSet.getString("JOB_TITLE");
//				    String jobId = myResultSet.getString("JOB_ID");
//				    String minSalary = myResultSet.getString("MIN_SALARY");
//				    String maxSalary = myResultSet.getString("MAX_SALARY");
//				System.out.printf("%-15s %-10s %-12s %s%n", jobTitle, jobId, minSalary, maxSalary);
//			}
		
		} catch (SQLException e) {
				
			e.printStackTrace();
		}
		
		
	}
	
}
