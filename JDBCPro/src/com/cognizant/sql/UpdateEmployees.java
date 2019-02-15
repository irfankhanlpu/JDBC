package com.cognizant.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateEmployees {
	
	public static void main(String args[])
	{
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
			System.out.println("Emloyee Salary:");
			double sal=sc.nextDouble();
			
		
			PreparedStatement statement=connection.prepareStatement("update  EMPLOYEESCOGNIZANT set EMP_SALARY=?  where EMP_ID=?");
			statement.setInt(2, empId);
			statement.setDouble(1, sal);
	
			int rows=statement.executeUpdate();
			if(rows>0)
			{
				System.out.println("Record Updated:");
				
			}
			else
			{
				System.out.println("Update Failed:");
			}

	}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
