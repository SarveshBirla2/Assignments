package menuClasses ;

import java.util.Map;
import java.sql.*;
import employee.assignment.utils.Input;
import javax.sql.*;
import javax.sql.rowset.*;
public class Appraisal {
    public static void appraisal(){
         String query="SELECT EMP.eid,EMP.salary,EMP.name FROM EMP WHERE eid=?";
         String updateQuery = "UPDATE EMP SET salary = ? WHERE eid = ?";
         //RowSetFactory rsf= ;
        try(
            JdbcRowSet rs = RowSetProvider.newFactory().createJdbcRowSet(); 
            JdbcRowSet rs2=RowSetProvider.newFactory().createJdbcRowSet();
        ){  
            rs.setUrl("jdbc:postgresql://localhost:5432/empdb");
            rs.setUsername("postgres");
            rs.setPassword("tiger");
            rs.setCommand(query);

            rs2.setUrl("jdbc:postgresql://localhost:5432/empdb");
            rs2.setUsername("postgres");
            rs2.setPassword("tiger");
            rs2.setCommand(updateQuery);

            System.out.print("Enter Employee ID whose salary is to be raised : ");
            int EmpID = Input.intInput();
            rs.setInt(1, EmpID);
            rs.execute();
            if(rs.next()){
                System.out.println("---------------------------------------");
                System.out.println("Employee Name : "+rs.getString(3));
                System.out.println("Current Salary : "+rs.getInt(2));
                System.out.println("---------------------------------------");

              System.out.print("Enter the Appraisal Amount : ");
              int increase = Input.intInput();
              int increasedSalary = increase + rs.getInt(2);
              rs2.setInt(1, increasedSalary);
              rs2.setInt(2, EmpID);
              rs2.execute();
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
