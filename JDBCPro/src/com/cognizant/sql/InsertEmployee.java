package com.cognizant.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertEmployee {

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
			
			System.out.println("Emloyee Name:");
			String nam=sc.next();
			
			System.out.println("Emloyee Salary:");
			double sal=sc.nextDouble();
			
			System.out.println("Emloyee Destination:");
			String des=sc.next();
			
			PreparedStatement statement=connection.prepareStatement("insert into EMPLOYEESCOGNIZANT values(?,?,?,?)");
			statement.setInt(1, empId);
			statement.setString(2, nam);
			statement.setDouble(3, sal);
			statement.setString(4, des);
			
			
			
			int rows=statement.executeUpdate();
			if(rows>0)
			{
				System.out.println("Record Inserted:");
				
			}
			else
			{
				System.out.println("Insert Failed:");
			}

	}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
}
}
