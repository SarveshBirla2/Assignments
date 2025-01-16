package employee.assignment;
import java.util.InputMismatchException;
import java.util.Scanner;
import employee.assignment.Designation;
import employee.assignment.Clerk;
import employee.assignment.Programmer;



public abstract class Employee{

    public int id ;
    String name;
    int age ;
    int salary;
    Designation designation;
    



    public static int countEmp=0 ;
   
    public Employee(int EmployeeId,int salary,Designation designation){
       this.getDetails();
       this.id = EmployeeId;
       this.salary=salary;
       this.designation=designation;
       countEmp++;
    }

     
    final public void display()
    { 
      System.out.println("-------------------------------------------");
      System.out.println("Name : "+name);
      System.out.println("EmployeeID : "+id);
      System.out.println("Age : "+ age);
      System.out.println("Salary : "+salary);
      System.out.println("Designation : "+designation);
      System.out.println();
      System.out.println("-------------------------------------------");
     }
     
    

    void getDetails(){
         name = EmployeeReader.NameReader();
         age=EmployeeReader.AgeReader(21, 60);   
    }
    

    public static Employee getEmployee(int EmployeeID,Designation designation){
        if(designation==Designation.CLERK){
           return Clerk.getClerk(EmployeeID);
        }
        if(designation==Designation.MANAGER){
           return Manager.getmManager(EmployeeID);
        }
        if(designation==Designation.PROGRAMMER){
            return Programmer.getProgrammer(EmployeeID);
        }

            return CEO.getCEO(EmployeeID);
    }

    public abstract void raiseSalary();
}















// class Employee{

   
    
//     static Employee allEmployee[] = new Employee[10];
//     static int employeeCount = 0; 
//     private String name ;
//     private int age;
//     private double salary;
//     private Designation designation;
    
//     Employee(String name, int age , Designation designation){
//         this.name = name ;
//         this.age = age;

//         if(designation == Designation.CLERK){
//             this.salary = 20000;
//         }
//         else if(designation == Designation.PROGRAMMER){
//            this.salary=30000;
//         }
//         else if(designation == Designation.MANAGER){
//             this.salary=100000;
//         }

//         this.designation = designation ;
        
//         allEmployee[employeeCount]=this;
//         employeeCount++;

//     }

//     static void display(){
//      for(int i=0;i<Employee.employeeCount;i++){
//         System.out.println("Name       : "+allEmployee[i].name);
//         System.out.println("Age        : "+allEmployee[i].age);
//         System.out.println("Salary     : "+allEmployee[i].salary);
//         System.out.println("Desination : "+allEmployee[i].designation);
//         System.out.println("---------------------------");
//      }
      
//     }

//     static void raiseSalary(){
//         for(int i=0;i<Employee.employeeCount;i++){

//          if(allEmployee[i].designation == Designation.CLERK){
//             allEmployee[i].salary+=2000;
//          }
//          if(allEmployee[i].designation == Designation.PROGRAMMER){
//             allEmployee[i].salary+=5000;
//          }
//          if(allEmployee[i].designation == Designation.MANAGER){
//             allEmployee[i].salary+=15000;
//         }
         
//          }
//     }
// }


