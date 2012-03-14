package com.pracownicy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DbTest {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		
		String sDriverName = "org.sqlite.JDBC";
		Class.forName(sDriverName);
		
		String sTempDb = "c:\\bd\\baza.sqlite";
		String sJdbc = "jdbc:sqlite";
		String sDbUrl = sJdbc + ":" + sTempDb;
		
		try {
			Connection connection = DriverManager.getConnection(sDbUrl);
			
			Statement stat = connection.createStatement();
			String query = "select * from pracownicy";
			ResultSet rs = stat.executeQuery(query);
			while(rs.next()){
				System.out.print("\n" + rs.getString("id") + " ");
				System.out.print(rs.getString("imie")+ " ");
				System.out.print(rs.getString("data_urodzenia") + " ");
				System.out.print(rs.getString("nazwisko")+" ");
				
			}
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("B³¹d po³¹czenia z baz¹ danych");
			
		}

	}

}
