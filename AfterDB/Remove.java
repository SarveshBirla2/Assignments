package menuClasses;
import employee.assignment.utils.Menu;
import employee.assignment.utils.Input;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Remove {
    public static void remove(){
                   String query= "SELECT EMP.eid,EMP.name,EMP.age,EMP.salary,DEPARTMENT.name as department ,DESIGNATION.name as designation FROM EMP INNER JOIN DEPARTMENT ON EMP.DEPARTMENT=DEPARTMENT.departmentID INNER JOIN DESIGNATION ON EMP.DESIGNATION=DESIGNATION.designationID WHERE EMP.eid = ?";
                   String deleteQuery ="DELETE FROM EMP WHERE eid = ?";
          
        try(
          Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/empdb","postgres","tiger");
          PreparedStatement pstmt = con.prepareStatement(query);
          PreparedStatement deletepstmt = con.prepareStatement(deleteQuery);
         
        ){
            System.out.print("Enter Employee ID to be Deleted : ");
            int EmpID = Input.intInput();
            pstmt.setInt(1, EmpID);
            ResultSet rs =pstmt.executeQuery();
            if(rs.next()){
                if(rs.getString(6).equals("CEO")){
                    System.out.println("--------------------------------");
                    System.out.println("Cannot Delete CEO ");
                    System.out.println("--------------------------------");
                    return;
                }
                System.out.println("---------------------------------------");
                System.out.println("EID : "+ rs.getString(1));
                System.out.println("Name : "+rs.getString(2));
                System.out.println("Age : "+rs.getString(3));
                System.out.println("Salary : "+rs.getString(4));
                System.out.println("Department : "+rs.getString(5));
                System.out.println("Designation : "+rs.getString(6));
                System.out.println("---------------------------------------");
                
                String menu ="Do You really want to Delete Above Employee \n1 .Yes \n2 .No";
                int ch=Menu.readChoice(2, menu);
                if(ch==1){
                  deletepstmt.setInt(1, EmpID);
                  deletepstmt.execute();

                  System.out.println(" Deleted !! ");
                }
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
