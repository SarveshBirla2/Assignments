package com.example.demo.controllers;

import java.sql.*;

public class DBConnection {
private static Connection con = null ; 
private DBConnection(){

}

public static Connection getConnection(){
  if(con==null){
    try{
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bankdb","postgres","tiger");
    }
    catch(Exception e){
        System.out.println(e);
    }
  }

  return con;
}

 public static void close(){
  try{
    con.close();
  }
  catch(Exception e){
    System.out.println(e);
  }
  
 }
}
