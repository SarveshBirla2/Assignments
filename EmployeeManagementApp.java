import java.util.*;

public class EmployeeManagementApp{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
    while(true){

        System.out.println("--------------------------------------------");
        System.out.println("1. Create\n2. Display\n3. Raise Salary\n4. Exit");
        System.out.println("--------------------------------------------");
        int menu = sc.nextInt();
        switch(menu){
            case 1:
            int currentCount=0;
            while(true){
                
                System.out.println("--------------------------------------------");
                System.out.println("1. Clerk\n2. Programmer\n3. Manager\n4. Exit");
                System.out.println("--------------------------------------------");
    
                int subMenu=sc.nextInt();
                if(subMenu == 4 ){
                    System.out.println("--------------------------------------------");
                    System.out.println("Employees Entered : "+currentCount);
                    System.out.println("--------------------------------------------");
                    break;
                }
                currentCount++;
                System.out.println("--------------------------------------------");
                
                System.out.print("Name : ");
                String name=sc.next();
                System.out.print("Age : ");
                int age= sc.nextInt() ;
                System.out.println("--------------------------------------------");
                    switch(subMenu){
                        case 1:
                           new Employee(name, age, Designation.CLERK);
                        break ;
                        case 2:
                           new Employee(name, age, Designation.PROGRAMMER);
                        break;
                        case 3:
                           new Employee(name, age, Designation.MANAGER);
                        break ;
                        default :
                        System.out.println("Invalid Input !");
                    }
            }
          
            break;
            case 2:
                Employee.display();
            break;
            case 3:
                Employee.raiseSalary();
            break;

            case 4:
            System.out.println("--------------------------------------------");
                System.out.println("Final Employee Count : "+Employee.employeeCount);
            System.out.println("--------------------------------------------");
               return;
            
            default :
            System.out.println("Invalid Input !");
        }

    }
   
    }
}