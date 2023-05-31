package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Artists {

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	private int id_Artists;
	private String name;
	private String genre;
	private String language;
	
	public Artists(String name,String language,String genre) {
		
		this.name=name;
		this.language=language;
		this.genre=genre;
		
		
	}
	
	public Artists(String name, String genre) {
		
		this.name=name;
		this.genre=genre;
		language="English";
		
	}
	public static void main(String[] args) {	
		
		Artists artist= new Artists("Nirvana","Grunge");
		
		try {
		Connection myConnection = DriverManager.getConnection("jdbc:mysql://sql7.freesqldatabase.com:3306/sql7622470", "sql7622470", "gkREcgyY8t");
		
		Statement mystatement = myConnection.createStatement();
		
		
		
		mystatement.executeUpdate("INSERT INTO Artists (Name) VALUES ('"+artist.getName()+"')");
		
		System.out.println("Artista introduit correctament");

	
	} catch (SQLException e) {
			
		e.printStackTrace();
	}}
	
}
