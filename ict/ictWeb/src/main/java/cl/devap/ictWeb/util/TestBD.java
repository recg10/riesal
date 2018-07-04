package cl.devap.ictWeb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;




public class TestBD {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			   Connection myConn = DriverManager.getConnection("JDBC:mysql://localhost:3306/riesal", "root", "root");
			   Statement myStmt = myConn.createStatement();
			   ResultSet myRs = myStmt.executeQuery("Select * from pre_cotizacion");

		} catch (Exception e) {
			e.printStackTrace();
		}
			   
	}

}
