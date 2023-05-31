package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Songs {
	
	private int song_ID;
	private String name;
	private String duration;
	
	public static void main(String[] args) {	
		
		
		Songs track= new Songs("Burn This Disco Out","3:41");
		
		try {
		Connection myConnection = DriverManager.getConnection("jdbc:mysql://sql7.freesqldatabase.com:3306/sql7622470", "sql7622470", "gkREcgyY8t");
		
		Statement mystatement = myConnection.createStatement();
		
		
		
		mystatement.executeUpdate("INSERT INTO Songs (Name,Duration,FK_IDAlbum) VALUES ('"+track.getName()+"','"+track.getDuration()+"',(SELECT ID_Album FROM Album WHERE Name='Off the Wall'))");
		
		System.out.println("Canço introduit correctament");

	
	} catch (SQLException e) {
			
		e.printStackTrace();
	}}
		
	public Songs(String name, String duration) {
		
		this.name=name;
		this.duration=duration;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	
	
}
