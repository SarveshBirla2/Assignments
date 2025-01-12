package Employee.assignment;
import java.util.Scanner;

enum Designation{
    CLERK,
    PROGRAMMER,
    MANAGER
    
}

abstract class Employee{

    int id ;
    String name;
    int age ;
    int salary;
    Designation designation;
    



    static int countEmp=0 ;
   
    Employee(int EmployeeId,int salary,Designation designation){
       this.getDetails();
       this.id = EmployeeId;
       this.salary=salary;
       this.designation=designation;
       countEmp++;
    }


    final public void display()
    {
      System.out.println("Name : "+name);
      System.out.println("EmployeeID : "+id);
      System.out.println("Age : "+ age);
      System.out.println("Salary : "+salary);
      System.out.println("Designation : "+designation);
      System.out.println();
     }


    void getDetails(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name : ");
        this.name=sc.nextLine();
        System.out.print("Enter Age : ");
        this.age=sc.nextInt();
    }

    public abstract void raiseSalary();
}

final class Clerk extends Employee{
   
    Clerk(int EmployeeID){
        super(EmployeeID,20000,Designation.CLERK);
    }
   public void raiseSalary(){
    salary += 2000;
   };
}

final class Programmer extends Employee{
   
    Programmer(int EmployeeID){
        super(EmployeeID,30000,Designation.PROGRAMMER);
    }
   public void raiseSalary(){
    salary += 5000;
   };
}

final class Manager extends Employee{
   
    Manager(int EmployeeID){
        super(EmployeeID,100000,Designation.MANAGER);
    }
   public void raiseSalary(){
    salary += 15000;
   };
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


