package menuClasses ;

import java.util.Map;
import java.sql.*;
import employee.assignment.utils.Input;

public class Appraisal {
    public static void appraisal(){
         String query="SELECT EMP.eid,EMP.salary,EMP.name FROM EMP WHERE eid=?";
         String updateQuery = "UPDATE EMP SET salary = ? WHERE eid = ?";
        try(
          Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/empdb","postgres","tiger");
          PreparedStatement pstmt = con.prepareStatement(query);
          PreparedStatement updatepstmt = con.prepareStatement(updateQuery);
        ){
            System.out.print("Enter Employee ID whose salary is to be raised : ");
            int EmpID = Input.intInput();
            pstmt.setInt(1, EmpID);
            ResultSet rs =pstmt.executeQuery();
            if(rs.next()){
                System.out.println("---------------------------------------");
                System.out.println("Employee Name : "+rs.getString(3));
                System.out.println("Current Salary : "+rs.getInt(2));
                System.out.println("---------------------------------------");

              System.out.print("Enter the Appraisal Amount : ");
              int increase = Input.intInput();
              int increasedSalary = increase + rs.getInt(2);
              updatepstmt.setInt(1, increasedSalary);
              updatepstmt.setInt(2, EmpID);
              updatepstmt.execute();
            }
            else{
                System.out.println("--------------------------------");
                System.out.println("Employee ID :"+EmpID+" does not exist ");
                System.out.println("--------------------------------");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }


    }
}
