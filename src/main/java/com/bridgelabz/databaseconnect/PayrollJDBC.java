package com.bridgelabz.databaseconnect;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.sql.Statement;

public class PayrollJDBC {

	 static final String jdbcURL = "jdbc:mysql://localhost:3306/payroll?useSSL=false";
	 static final String userName = "root";
	 static final String password = "root";
	 static final String query = "SELECT id, name, salary, start FROM employee_payroll";
	
	public static void main(String args[]) throws SQLException {

		Connection connection = DriverManager.getConnection(jdbcURL, userName, password);
		         Statement state = connection.createStatement();
		         ResultSet result = state.executeQuery(query);
				try{		      
		         while(result.next()){
		            //Display values
		            System.out.print("ID: " + result.getInt("id"));
		            System.out.print(", Name: " + result.getString("name"));
		            System.out.print(", Salary: " + result.getDouble("salary"));
		            System.out.println(", Start: " + result.getDate("start"));
		         }
		      } catch (SQLException e) {
		         new SQLException("An error occured!");
		      } 
			connection.close();
	}
}
