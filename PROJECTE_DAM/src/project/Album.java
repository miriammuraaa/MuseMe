package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Album {
	
	private int album_ID;
	private String name;
	private LocalDate LaunchDate;
	private float price;
	private String author;
	private Songs[] songsAlbum;
	
	public Album(String name,LocalDate LaunchDate,float price,String author,Songs[]songsAlbum ) {
		
		this.name=name;
		this.LaunchDate=LaunchDate;
		this.price=price;
		this.author=author;
		this.songsAlbum=songsAlbum;
		
		
		
	}
	public Album(String name,float price) {
		
		this.name=name;
		this.price=price;
		
		
		
	}
	
	
	public static void main(String[] args) {	
		
		Album album= new Album("Nevermind",(float) 29.99);
		
		try {
		Connection myConnection = DriverManager.getConnection("jdbc:mysql://sql7.freesqldatabase.com:3306/sql7622470", "sql7622470", "gkREcgyY8t");
		
		Statement mystatement = myConnection.createStatement();
		
		mystatement.executeUpdate("INSERT INTO Album (Name,LaunchDate,Price,FK_IDartist) VALUES ('"+album.getName()+"','1991-09-26',34.99,(SELECT ID_Artist FROM Artists WHERE Name='Nirvana'))");
		
		System.out.println("Album introduit correctament");

	
	} catch (SQLException e) {
			
		e.printStackTrace();
	}}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Songs[] getSongsAlbum() {
		return songsAlbum;
	}

	public void setSongsAlbum(Songs[] songsAlbum) {
		this.songsAlbum = songsAlbum;
	}
}
