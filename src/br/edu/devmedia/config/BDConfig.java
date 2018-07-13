package br.edu.devmedia.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConfig {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {

		String DATABASE_URL = "jdbc:mariadb://nt71li6axbkq1q6a.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/d8nh9cxk373rv5xb";
		String DATABASE_USER = "k3flcw2gglu6jlwk";
		String DATABASE_PASSWORD = "u70bdmz4nchr5fv2";

		Class.forName("org.mariadb.jdbc.Driver");
		return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
		
	}

}
