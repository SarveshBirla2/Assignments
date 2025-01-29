package menuClasses;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import employee.assignment.utils.Menu;
public class Display {
    public static void display(){
    String menu=" Sort By : \n1. ID\n2. Name \n3. Designation  \n4. Age \n5. Salary\n6. Exit" ;
    int ch = Menu.readChoice(6, menu);
    if(ch==6)return ;
    else {
        try(
          Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/empdb","postgres","tiger");
          Statement stmt = con.createStatement();
        ){ 
        String query ="";
          switch(ch){
            case 1 : 
              query+="SELECT EMP.eid,EMP.name,EMP.age,EMP.salary,DEPARTMENT.name as department ,DESIGNATION.name as designation FROM EMP INNER JOIN DEPARTMENT ON EMP.DEPARTMENT=DEPARTMENT.departmentID INNER JOIN DESIGNATION ON EMP.DESIGNATION=DESIGNATION.designationID ORDER BY eid ASC";
            break;
            case 2 :
            query+="SELECT EMP.eid,EMP.name,EMP.age,EMP.salary,DEPARTMENT.name as department ,DESIGNATION.name as designation FROM EMP INNER JOIN DEPARTMENT ON EMP.DEPARTMENT=DEPARTMENT.departmentID INNER JOIN DESIGNATION ON EMP.DESIGNATION=DESIGNATION.designationID ORDER BY EMP.name ASC";
            break;
            case 3 :
            query+="SELECT EMP.eid,EMP.name,EMP.age,EMP.salary,DEPARTMENT.name as department ,DESIGNATION.name as designation FROM EMP INNER JOIN DEPARTMENT ON EMP.DEPARTMENT=DEPARTMENT.departmentID INNER JOIN DESIGNATION ON EMP.DESIGNATION=DESIGNATION.designationID ORDER BY Designation.name ASC";

            break;
            case 4 :
            query+="SELECT EMP.eid,EMP.name,EMP.age,EMP.salary,DEPARTMENT.name as department ,DESIGNATION.name as designation FROM EMP INNER JOIN DEPARTMENT ON EMP.DEPARTMENT=DEPARTMENT.departmentID INNER JOIN DESIGNATION ON EMP.DESIGNATION=DESIGNATION.designationID ORDER BY EMP.age ASC";
            break;
            case 5 :
            query+="SELECT EMP.eid,EMP.name,EMP.age,EMP.salary,DEPARTMENT.name as department ,DESIGNATION.name as designation FROM EMP INNER JOIN DEPARTMENT ON EMP.DEPARTMENT=DEPARTMENT.departmentID INNER JOIN DESIGNATION ON EMP.DESIGNATION=DESIGNATION.designationID ORDER BY EMP.salary ASC";
            break;
            
          }
          ResultSet rs= stmt.executeQuery(query);
          while(rs.next()){
          System.out.println("------------------------------------------------");
          System.out.println("EID : "+ rs.getString(1));
          System.out.println("Name : "+rs.getString(2));
          System.out.println("Age : "+rs.getString(3));
          System.out.println("Salary : "+rs.getString(4));
          System.out.println("Department : "+rs.getString(5));
          System.out.println("Designation : "+rs.getString(6));
          System.out.println("------------------------------------------------");
          }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    }
}
