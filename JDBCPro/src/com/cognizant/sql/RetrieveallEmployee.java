package com.cognizant.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetrieveallEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection connection=
					DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","system","cognizant");
					Statement statement=connection.createStatement();
					ResultSet resultSet=statement.executeQuery("select * from EMPLOYEESCOGNIZANT");
					System.out.println("EMP ID \t" + "EMP NAME \t" + "EMP DESIGNATION \n");
					while(resultSet.next())
					{
						System.out.println(resultSet.getInt("EMP_ID") + "\t" + resultSet.getString("EMP_NAME")+ "\t"+resultSet.getDouble("EMP_SALARY") + "\t" + resultSet.getString("EMP_DESIGNATION"));
					}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
