package EMA;
import employee.assignment.Employee;
import employee.assignment.EmployeeFactory;

import employee.assignment.DB.DBConnection;
import employee.assignment.DB.DBOperation;
import employee.assignment.util.*;
public class EmployeeManagementApp {
	public static int empCount=0;
	static{
     empCount = Employee.getEmployeeCount();
	}
    public static void main(String[] args) {
        try{
            int ch1=0,ch2=0;
            do{
              String menu = "1.Create\n2.Display\n3.Appraisal\n4.Search\n5.Remove\n6.Exit";
              ch1 = Menu.readChoice(6, menu);

              switch (ch1) {
                case 1:
              	     EmployeeFactory.getEmployee();
                     break;
                case 2:
                     Employee.display();
                     break;
                case 3:
                     Employee.raiseSalary();
                     break;
                case 4:
                     Employee.search();
                case 5:
                     Employee.delete();                    
                     break;
                case 6:
                     break;
              }
            }while(ch1!=6);
            

        }
        catch(Exception e){
            System.out.println(e);
        }
        finally {
        	DBConnection.close();
        }
    }
}
