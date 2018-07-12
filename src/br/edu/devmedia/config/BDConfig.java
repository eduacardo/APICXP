package br.edu.devmedia.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConfig {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {

		String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/notes_db";
		String DATABASE_USER = "root";
		String DATABASE_PASSWORD = "12345";

		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);

	}

}
