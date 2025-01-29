import employee.assignment.utils.Menu;
import menuClasses.Create;
import menuClasses.Display;
import menuClasses.Remove;
import menuClasses.Search;
import menuClasses.Appraisal;

public class EmployeeManagementApp {
    
    public static void main(String[] args) {
        try{
            int ch1=0,ch2=0;
            do{
              String menu = "1.Create\n2.Display\n3.Appraisal\n4.Search\n5.Remove\n6.Exit";
              ch1 = Menu.readChoice(6, menu);

              switch (ch1) {
                case 1:
                     Create.createEmp();
                     break;
                case 2:
                     Display.display();
                     break;
                case 3:
                     Appraisal.appraisal();
                     break;
                case 4:
                     Search.search();
                     break;
                case 5:
                    Remove.remove();                    
                     break;
                case 6:
                     break;
              }
            }while(ch1!=6);
            

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}


//-----------------------
//    1. Create
//    2. Display
//    3. Appraisal
//    4. Search
//    5. Remove
//    6. Exit
// -----------------------
// Enter choice :- 1
 
// (This is for Option 1)
// -----------------------
//    1. Clerk
//    2. Programmer
//    3. Manager
//    4. Others
//    5. Exit
// -----------------------
// Enter choice :- 1
 
// (This is for Option 2)
// -----------------------
//    1. By ID
//    2. Name
//    3. Designation
//    4. Age
//    5. Salary
//    6. Exit
// -----------------------
// Enter choice :- 1
 
 
// EMPLOYEE (EID, NAME, AGE, SALARY, DESIGNATION, DEPARTMENT)