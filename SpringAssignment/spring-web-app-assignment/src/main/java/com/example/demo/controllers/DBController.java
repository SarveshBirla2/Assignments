package com.example.demo.controllers;
import java.sql.*;

public class DBController {
   
	private static Connection con = DBConnection.getConnection();
	
	
	
	public static void save(int Customer_id,String name,String password) {
		
		String query="INSERT INTO Customer values(?,?,?)";
		try(
				PreparedStatement pstmt = con.prepareStatement(query) ;
			){
			pstmt.setInt(1, Customer_id);
			pstmt.setString(2, name);
			pstmt.setString(3, password);
			pstmt.execute();
		}
		 catch(Exception e) {
			System.out.println(e);
		 }
		 
	}
	
	public static String fetchName(int Customer_id,String password) {
		
		String query="SELECT name FROM customer WHERE Customer_id=? AND password=?";
		try(
				PreparedStatement pstmt = con.prepareStatement(query) ;
			){
			pstmt.setInt(1, Customer_id);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		
		}
		 catch(Exception e) {
			System.out.println(e);
		 }
   return null;   
	}
}
