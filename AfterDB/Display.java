package menuClasses;
import java.sql.*;
import javax.sql.*;
import javax.sql.rowset.*;
import employee.assignment.utils.Menu;
public class Display {
    public static void display(){
    String menu=" Sort By : \n1. ID\n2. Name \n3. Designation  \n4. Age \n5. Salary\n6. Exit" ;
    int ch = Menu.readChoice(6, menu);
    if(ch==6)return ;
    else {
       //RowSetFactory rsf= ;
        try(
          
          JdbcRowSet rs = RowSetProvider.newFactory().createJdbcRowSet(); 
        
        ){ 
          rs.setUrl("jdbc:postgresql://localhost:5432/empdb");
          rs.setUsername("postgres");
          rs.setPassword("tiger");
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
          rs.setCommand(query);
          rs.execute();

          System.out.println("---------------------------------------------------------------");
          System.out.printf("%-10s %-15s %-5s %-10s %-20s %-15s%n", 
                  "EID", "Name", "Age", "Salary", "Department", "Designation");
          System.out.println("---------------------------------------------------------------");

          while (rs.next()){
                      System.out.printf("%-10s %-15s %-5s %-10s %-15s %-15s%n",
                      rs.getString(1), rs.getString(2), rs.getString(3),
                      rs.getString(4), rs.getString(5), rs.getString(6));
             } 

          System.out.println("---------------------------------------------------------------");

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    }
}
