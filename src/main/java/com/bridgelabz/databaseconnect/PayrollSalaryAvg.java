package com.bridgelabz.databaseconnect;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.sql.Statement;

public class PayrollSalaryAvg {

	 static final String jdbcURL = "jdbc:mysql://localhost:3306/payroll?useSSL=false";
	 static final String userName = "root";
	 static final String password = "root";
	 static final String query = "SELECT gender, AVG(salary) as avg_salary FROM employee_payroll GROUP BY gender;";
	
	public static void main(String args[]) throws SQLException {

		Connection connection = DriverManager.getConnection(jdbcURL, userName, password);
		        try{		      
		        	Statement state = connection.createStatement();
		                 ResultSet result = state.executeQuery(query);
		        	
		         while(result.next()){
		            //Display values
		           String gender = result.getString("gender");
		           double salary = result.getDouble("avg_salary");
		           System.out.println(gender +" "+salary);
		         }
		      } catch (SQLException e) {
		         new SQLException("An error occured!");
		      } 
			connection.close();
	}
}
