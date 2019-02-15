package com.cognizant.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RetrieveEmployeeById {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(
				Scanner sc=new Scanner(System.in);
				Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","system","cognizant");
				){
			System.out.println("Emloyee Id:");
			int empId=sc.nextInt();
			PreparedStatement statement=connection.prepareStatement("select * from EMPLOYEESCOGNIZANT where EMP_ID=?");
			statement.setInt(1, empId);
			ResultSet resultSet=statement.executeQuery();
			System.out.println("EMP ID \t" + "EMP NAME \t" +"EMP_SALARY \t" +"EMP DESIGNATION \n");
			while(resultSet.next())
			{
				System.out.println(resultSet.getInt("EMP_ID") + "\t" + resultSet.getString("EMP_NAME")+ "\t"+resultSet.getDouble("EMP_SALARY") + "\t" + resultSet.getString("EMP_DESIGNATION"));
				
			}
			
		}

	catch (SQLException e)
	{
		e.printStackTrace();

	}

}
}
