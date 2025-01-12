import java.util.Scanner;
import Employee.assignment.*;


public class EmployeeManagementApp
{
        public static void main(String[] args)
   {
        int ch1 = 0, ch2 = 0;
        
        Scanner sc = new Scanner(System.in);
        Employee emp[] = new Employee[100];
        do{
            System.out.println("-------------------------------------");
            System.out.println("1. Create Employee");
            System.out.println("2. Display");
            System.out.println("3. Raise Salary");
            System.out.println("4. Remove ");
            System.out.println("5. Exit");
            System.out.println("-------------------------------------");
            System.out.print("Enter your choice: ");
            ch1 = sc.nextInt();
            switch(ch1)
            {
                case 1:

                do
                {
                    System.out.println("---------------------------------------------");
                    System.out.println("1. Create Clerk");
                    System.out.println("2. Create Programmer");
                    System.out.println("3. Create Manager");
                    System.out.println("4. Back");
                    System.out.println("--------------------------------------------");
                    System.out.print("Enter your choice: ");
                    ch2 = sc.nextInt();



                    int EmployeeID=-1;
                    if(ch2!=4){
                        while(EmployeeID==-1){

                        System.out.print(" Enter the EmployeeId :");
                        EmployeeID=sc.nextInt();
                        for(int i=0;i<Employee.countEmp;i++){
                           if(emp[i].id==EmployeeID){
                            System.out.println(" Employee ID Already exist, enter a different Employee ID");
                            EmployeeID=-1;
                            break;
                           }
                        }
                    }
                    }
                    switch(ch2){
                        case 1:
                        emp[Employee.countEmp] = new Clerk(EmployeeID);
                        break;
                        case 2:
                        emp[Employee.countEmp] = new Programmer(EmployeeID);
                        break;
                        case 3:
                        emp[Employee.countEmp] = new Manager(EmployeeID);
                        break;
                    }
                }while(ch2 != 4);

                case 2:
                if (Employee.countEmp == 0){
                    System.out.println("No Employee Present to Display");
                }
                for (int i = 0; i < Employee.countEmp; i++){
                emp[i].display();
                }
                break;

                case 3:
                if (Employee.countEmp == 0){
                    System.out.println("No Employee Present to Raise Salary");
                }
                for (int i = 0; i < Employee.countEmp; i++){
                   emp[i].raiseSalary();
                }
                break;

                case 4:
                System.out.println("Do you really want to delete");
                System.out.println("1.Yes    2.No");
                int ch3=sc.nextInt();
                  switch (ch3) {
                    case 1 :
                        System.out.println("Enter The ID of Employee to be deleted");
                        int  idToDelete = sc.nextInt();
                        boolean found=false;
                        for(int i=0;i<Employee.countEmp;i++){
                            if(emp[i].id==idToDelete){
                               found=true;
                               emp[i]=null;
                             
                               continue;
                            }
                            if(found==true){
                                emp[i-1]=emp[i];
                            }
                        }
                        if(found==false ){
                        System.out.println("----------------------------------");
                        System.out.println("Employee ID not found");
                        System.out.println("----------------------------------");
                         }
                        else {
                            Employee.countEmp--;
                            System.out.println("----------------------------------");
                            System.out.println("Deleted");
                            System.out.println("----------------------------------"); 
                        }
                        break;
                    case 2 :

                       break;
                    default:
                     System.out.println("Enter the valid choice !! ");
                        break;
                  }
               case 5:
                break;
            }
        }while(ch1 != 5);
    
        System.out.println("Total Employees Present in the Company: " + Employee.countEmp);


    }

}















// import java.util.*;

// public class EmployeeManagementApp{
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//     while(true){

//         System.out.println("--------------------------------------------");
//         System.out.println("1. Create\n2. Display\n3. Raise Salary\n4. Exit");
//         System.out.println("--------------------------------------------");
//         int menu = sc.nextInt();
//         switch(menu){
//             case 1:
//             int currentCount=0;
//             while(true){
                
//                 System.out.println("--------------------------------------------");
//                 System.out.println("1. Clerk\n2. Programmer\n3. Manager\n4. Exit");
//                 System.out.println("--------------------------------------------");
    
//                 int subMenu=sc.nextInt();
//                 if(subMenu == 4 ){
//                     System.out.println("--------------------------------------------");
//                     System.out.println("Employees Entered : "+currentCount);
//                     System.out.println("--------------------------------------------");
//                     break;
//                 }
//                 currentCount++;
//                 System.out.println("--------------------------------------------");
                
//                 System.out.print("Name : ");
//                 String name=sc.next();
//                 System.out.print("Age : ");
//                 int age= sc.nextInt() ;
//                 System.out.println("--------------------------------------------");
//                     switch(subMenu){
//                         case 1:
//                            new Employee(name, age, Designation.CLERK);
//                         break ;
//                         case 2:
//                            new Employee(name, age, Designation.PROGRAMMER);
//                         break;
//                         case 3:
//                            new Employee(name, age, Designation.MANAGER);
//                         break ;
//                         default :
//                         System.out.println("Invalid Input !");
//                     }
//             }
          
//             break;
//             case 2:
//                 Employee.display();
//             break;
//             case 3:
//                 Employee.raiseSalary();
//             break;

//             case 4:
//             System.out.println("--------------------------------------------");
//                 System.out.println("Final Employee Count : "+Employee.employeeCount);
//             System.out.println("--------------------------------------------");
//             sc.close();
//                return;
            
//             default :
//             System.out.println("Invalid Input !");
//         }

//     }
     
//     }
// }