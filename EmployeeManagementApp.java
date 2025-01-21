import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Map;

import employee.assignment.EmployeeMap;
import employee.assignment.Employee;
import employee.assignment.utils.Menu;
import employee.assignment.InvalidChoiceException;
import employee.assignment.Designation;

public class EmployeeManagementApp
{
        public static void main(String[] args)
   {
        int ch1 = 0, ch2 = 0;
        
        Scanner sc = new Scanner(System.in);
       // Employee emp[] = new Employee[100];
        

        System.out.println("Enter CEO Details : ");
        System.out.println("--------------------------");
        EmployeeMap.Employees.put(1,Employee.getEmployee(1,Designation.CEO));

        do{    
            
                
                String menu = "1. Create Employee\n2. Display\n3. Raise Salary\n4. Remove\n5. Search\n6.Exit" ;
            
                ch1 = Menu.readChoice(6, menu);
                
             switch(ch1)
            {
                case 1:

                do
                {   
                    
                    String submenu = "1. Create Clerk\n2. Create Programmer\n3. Create Manager\n4. Back "; 
                    ch2 = Menu.readChoice(4,submenu);
                    
                    int EmployeeID=-1;
                    if(ch2!=4){
                        while(EmployeeID==-1){
                       
                       while(true){    
                         try{
                            
                                System.out.print(" Enter the EmployeeId :");
                                EmployeeID=sc.nextInt();
                                if(EmployeeID<=0) throw new InvalidChoiceException("Enter Valid Employee ID greater than 0 ");
                                else break;
                           }
                        catch(InputMismatchException e){
                            System.out.println("-------------------------------------------");
                            System.out.println("Enter the Correct EmployeeID in Integer Only !!");
                            System.out.println("-------------------------------------------");
                            sc.nextLine();
                        }
                        catch(InvalidChoiceException e){
                            System.out.println("-------------------------------------------");
                            System.out.println(e.getMessage());
                            System.out.println("-------------------------------------------");
                            sc.nextLine();
                        }
                       }   
                       
                        if(EmployeeMap.Employees.containsKey(EmployeeID)){
                            System.out.println("-------------------------------------------");
                            System.out.println(" Employee ID Already exist, enter a different Employee ID");
                            System.out.println("-------------------------------------------");
                            EmployeeID=-1;
                        }

                        // for(int i=0;i<Employee.countEmp;i++){
                        //    if(emp[i].getId()==EmployeeID){
                        //     System.out.println("-------------------------------------------");
                        //     System.out.println(" Employee ID Already exist, enter a different Employee ID");
                        //     System.out.println("-------------------------------------------");
                        //     EmployeeID=-1;
                        //     break;
                        //    }
                        // }
                    }
                    }
                    switch(ch2){
                        case 1:
                        EmployeeMap.Employees.put(EmployeeID,Employee.getEmployee(EmployeeID,Designation.CLERK));
                        break;
                        case 2:
                        EmployeeMap.Employees.put(EmployeeID,Employee.getEmployee(EmployeeID,Designation.PROGRAMMER));
                        break;
                        case 3:
                        EmployeeMap.Employees.put(EmployeeID,Employee.getEmployee(EmployeeID,Designation.MANAGER));
                        break;
                    }
                } while(ch2 != 4);

                case 2:
                if (EmployeeMap.empCount == 0){
                    System.out.println("No Employee Present to Display");
                }
                Iterator mi = EmployeeMap.Employees.entrySet().iterator();

                while(mi.hasNext()){
                    Map.Entry me = (Map.Entry)mi.next();
                    Employee emp=(Employee)me.getValue();
                    emp.display();  
                }
                break;

                case 3:
                if (EmployeeMap.empCount == 0){
                    System.out.println("No Employee Present to Raise Salary");
                }
                Iterator mi2 = EmployeeMap.Employees.entrySet().iterator();
                while(mi2.hasNext()){
                    Map.Entry me = (Map.Entry)mi2.next();
                    Employee emp=(Employee)me.getValue();
                    emp.raiseSalary();  
                }
                break;

                case 4:
                System.out.println("-------------------------------------------");
                System.out.println("Do you really want to delete");
                int ch3=0;
                String submenu="1.Yes\n2.No";
                ch3=Menu.readChoice(2, submenu);
                  switch (ch3) {
                    case 1 :
                        System.out.print("Enter The ID of Employee to be deleted  :");
                        int  idToDelete = sc.nextInt();
                        if(idToDelete==1){
                            System.out.println("-----------------------------");
                            System.out.println("Cannot Delete CEO ");
                            System.out.println("-----------------------------");
                            break;
                        }

                        if(EmployeeMap.Employees.containsKey(idToDelete)){

                            EmployeeMap.empCount--;
                            Employee emp=(Employee)EmployeeMap.Employees.remove(idToDelete);
                            System.out.println("----------------------------------");
                            System.out.println("Deleted Employee :");
                            emp.display();
                            System.out.println("----------------------------------"); 
                        }
                        else{
                        System.out.println("----------------------------------");
                        System.out.println("Employee ID not found");
                        System.out.println("----------------------------------");
                        }
                        // boolean found=false;
                        // for(int i=0;i<;i++){
                        //     if(emp[i].getId()==idToDelete){
                        //        found=true;
                        //        emp[i]=null;
                             
                        //        continue;
                        //     }
                        //     if(found==true){
                        //         emp[i-1]=emp[i];
                        //     }
                        // }
                        // if(found==false ){
                        // System.out.println("----------------------------------");
                        // System.out.println("Employee ID not found");
                        // System.out.println("----------------------------------");
                        //  }
                        // else {
                        //     Employee.countEmp--;
                        //     System.out.println("----------------------------------");
                        //     System.out.println("Deleted");
                        //     System.out.println("----------------------------------"); 
                        // }
                        // break;
                    case 2 :

                       break;
                    default:
                     System.out.println("Enter the valid choice !! ");
                        break;
                  }
               case 5:
                System.out.print("Enter the Employee ID to search ");
                int idToSearch = sc.nextInt();
                if(EmployeeMap.Employees.containsKey(idToSearch)){
                    Employee emp=(Employee)EmployeeMap.Employees.get(idToSearch);
                    emp.display();
                }
                else{
                  System.out.println("----------------------------------");
                  System.out.println("Employee ID not found");
                  System.out.println("----------------------------------");
                }
               case 6:
                break;
            }
        }while(ch1 != 6);
    
        System.out.println("Total Employees Present in the Company: " + EmployeeMap.empCount);
         

        
        sc.close();
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