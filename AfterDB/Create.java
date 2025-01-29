package menuClasses;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import employee.assignment.EmployeeReader;


public class Create {
    
    public static void createEmp(){
        while(true){
            int designation = EmployeeReader.designationReader() ;
            if(designation==-1)break;
            int department = EmployeeReader.departmentReader() ;
            if(department==-1)continue;
            String name = EmployeeReader.NameReader();
            int age = EmployeeReader.AgeReader(20, 60);
            int salary = EmployeeReader.salaryReader();
            

            try(
                 Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/empdb","postgres","tiger");
                 PreparedStatement pstmt = con.prepareStatement("insert into EMP(name,age,salary,designation,department) values (?,?,?,?,?)");
            )
            {
               pstmt.setString(1, name);
               pstmt.setInt(2, age);
               pstmt.setInt(3, salary);
               pstmt.setInt(4, designation);
               pstmt.setInt(5, department);
               pstmt.execute();
            }
            catch(Exception e){
                System.out.println(e);
            }

        }

    }

    
};
