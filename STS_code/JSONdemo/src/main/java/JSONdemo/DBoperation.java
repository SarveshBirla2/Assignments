package JSONdemo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DBoperation {
	private static Connection con = DBConnection.getConnection();
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static JSONParser parser = new JSONParser();
	public static void create() {
		String query = "INSERT INTO try_json(Employee) values(?::json)";
		try(PreparedStatement pstmt = con.prepareStatement(query) ;)
		{
			JSONObject employee = new JSONObject();
			   System.out.print("Enter Name :");
			   String name = br.readLine();
		       employee.put("name",name);
		       System.out.print("Enter Age :");
			   int age = Integer.parseInt(br.readLine());
		       employee.put("age",age);
		       System.out.print("Enter Salary :");
			   int salary = Integer.parseInt(br.readLine());
		       employee.put("salary",salary);
		       System.out.print("Enter Designation :");
			   String desig = br.readLine();
		       employee.put("designation",desig);
		       
		       pstmt.setString(1, employee.toJSONString());
		       pstmt.executeUpdate();      
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public static void read() {
		String query = "SELECT Employee FROM try_json";
		try(PreparedStatement pstmt = con.prepareStatement(query) ;)
		{
		    ResultSet rs = pstmt.executeQuery();
		    while(rs.next()) {
		    	  String jsonString = rs.getString("Employee");

		           // Parse it into a JSONObject
		           JSONObject jsonObject = (JSONObject) parser.parse(jsonString);

		           // Extract values
		           String name = (String) jsonObject.get("name");
		           long age = (long) jsonObject.get("age");
		           String designation = (String) jsonObject.get("designation");
		           long salary = (long) jsonObject.get("salary");

		           // Print JSON data
		           System.out.println("-------------------------------------------------");
		           System.out.println("Name: " + name);
		           System.out.println("Age: " + age);
		           System.out.println("Designation: " + designation);
		           System.out.println("Salary: " + salary);
		           System.out.println("-------------------------------------------------");
		    }
		    
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	public static void update() {
		
		 String query = "UPDATE try_json SET Employee = jsonb_set(Employee, ? :: text[], to_jsonb(?), false) WHERE Employee->>'name' = ?" ;
		try(PreparedStatement pstmt = con.prepareStatement(query) ;)
		{
		   System.out.print("Enter name to update ");
		   String name = br.readLine();
		   
		   System.out.println("What do you want to update? \n (age, salary, designation) ");
		   String to_update = br.readLine();
		   
		   System.out.print("Enter new value: ");
	       String newValue = br.readLine();
	       
	       String formatToUpdate = "{"+ to_update + "}";
	       
	       pstmt.setString(1, formatToUpdate);
	       
	       switch(to_update) {
	       case "age":
	    	   
	       case "salary" : pstmt.setInt(2, Integer.parseInt(newValue));
	    	    break ;
	       case "designation":pstmt.setString(2,newValue);
	    	   break ;
	    	   
	       }
	       pstmt.setString(3, name );
	       
	       int rowsUpdated = pstmt.executeUpdate();
           if (rowsUpdated != 0) {
               System.out.println("Successfully updated " + to_update + " for " + name);
           } else {
               System.out.println("No employee found with name: " + name );
           }

		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	public static void delete(){
		
		String query = "DELETE from try_json where Employee->>'name' = ?";
		try(PreparedStatement pstmt = con.prepareStatement(query) ;)
		{
		  System.out.print("Enter name to delete :");
		  String name = br.readLine();
		  pstmt.setString(1, name);
		 int x=  pstmt.executeUpdate();
		 System.out.println(x + "  Row Deleted");
		  
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void close() {
		try {
			br.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
