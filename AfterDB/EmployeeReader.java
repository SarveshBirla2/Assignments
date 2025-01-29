package employee.assignment ;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import employee.assignment.utils.Menu;
import employee.assignment.utils.Input;
import java.sql.*;
public class EmployeeReader {
    public static String NameReader(){
     while(true){
        System.out.print("Enter Name :");
        String input = Input.stringInput();

        String namePattern = "[A-Z][a-zA-Z]*\\s[A-Z][a-zA-Z]*";
        Pattern p = Pattern.compile(namePattern);
        Matcher validated=p.matcher(input);

        if(validated.matches()){
            return input;
        }
       
        System.out.println("Enter Name in following format : Firstname Lastname ");
        
     }
    }


       public static int AgeReader(int min,int max ){
    while(true){
        System.out.print("Enter Age :");
        int age = Input.intInput();
         if(age<min || age > max){
            System.out.println("Enter age between "+min+" and "+max);
         }
         else return age;
    } 
      }

      public static int salaryReader(){
        while(true){
            System.out.print("Enter Salary :");
            int salary = Input.intInput();
            
             return salary ;
        } 
          }

        public static int designationReader(){
            
            try(
                          Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/empdb","postgres","tiger");
                          Statement stmt = con.createStatement();
            ){        
                  
                      HashMap<String,Integer> hmp = new HashMap<String,Integer>() ;
                      ResultSet rs = stmt.executeQuery("select * from DESIGNATION");
                      String menu="";
                  
                      while(rs.next()){
                        //System.out.println("going");
                        hmp.put( rs.getString(2),rs.getInt(1));
                        menu=menu+hmp.size()+". "+rs.getString(2)+"\n";
                      }
                      menu=menu+(hmp.size()+1)+". Other\n"+(hmp.size()+2)+". Exit\n";
                      int ch=Menu.readChoice((hmp.size()+2), menu);
                      if(ch==(hmp.size()+2))return -1;
                      if(ch==(hmp.size()+1)){
                        while(true){
                          System.out.print("Enter Designation name : ");
                          String desig = "";
                          desig = Input.stringInput() ;
                          if(desig != ""){
                            System.out.println(desig);
                            stmt.executeUpdate("insert into DESIGNATION(name) values('"+desig+"')");
                            return ch;
                          }
                        }
                      }
                      return ch;     
            }
            catch(Exception e){
                System.out.println("Error happening");
                System.out.println(e);
            }
               return -1;
          }



          public static int departmentReader(){

            try(
                          Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/empdb","postgres","tiger");
                          Statement stmt = con.createStatement();
            ){        
                  
                      HashMap<String,Integer> hmp = new HashMap<String,Integer>() ;
                      ResultSet rs = stmt.executeQuery("select * from DEPARTMENT");
                      String menu="";
                  
                      while(rs.next()){
                        //System.out.println("going");
                        hmp.put( rs.getString(2),rs.getInt(1));
                        menu=menu+hmp.size()+". "+rs.getString(2)+"\n";
                      }
                      menu=menu+(hmp.size()+1)+". Other\n"+(hmp.size()+2)+". Exit\n";
                      int ch=Menu.readChoice((hmp.size()+2), menu);
                      if(ch==(hmp.size()+2))return -1;
                      if(ch==(hmp.size()+1)){
                        while(true){
                          System.out.print("Enter Department name : ");
                          String depart = "";
                          depart = Input.stringInput() ;
                          if(depart != ""){
                            System.out.println(depart);
                            stmt.executeUpdate("insert into DEPARTMENT(name) values('"+depart+"')");
                            return ch;
                          }
                        }
                      }
                      return ch;     
            }
            catch(Exception e){
                System.out.println("Error happening");
                System.out.println(e);
            }
               return -1;

          }


          




}


