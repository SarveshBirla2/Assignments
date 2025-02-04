package menuClasses;
import java.sql.*;
import employee.assignment.EmployeeReader;
import javax.sql.*;
import javax.sql.rowset.*;


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
            
            
            //RowSetFactory rsf= 
            try(
               
              JdbcRowSet rs = RowSetProvider.newFactory().createJdbcRowSet(); 
             
             //    PreparedStatement pstmt = con.prepareStatement("insert into EMP(name,age,salary,designation,department) values (?,?,?,?,?)");
            )
            {  


              rs.setUrl("jdbc:postgresql://localhost:5432/empdb");
              rs.setUsername("postgres");
              rs.setPassword("tiger");

              //rs.setCommand("insert into EMP(name,age,salary,designation,department) values (?,?,?,?,?)");
              rs.setCommand("SELECT name FROM EMP");
               rs.execute();
               rs.moveToInsertRow();
               rs.updateString("name", name);
               rs.updateInt("age", age);
               rs.updateInt("salary", salary);
               rs.updateInt("designation", designation);
               rs.updateInt("department", department);
               rs.insertRow();
               rs.moveToCurrentRow();
               //rs.commit();
            //    pstmt.setString(1, name);
            //    pstmt.setInt(2, age);
            //    pstmt.setInt(3, salary);
            //    pstmt.setInt(4, designation);
            //    pstmt.setInt(5, department);
            //    pstmt.execute();
            }
            catch(Exception e){
                System.out.println(e);
            }

        }

    }

    
};
