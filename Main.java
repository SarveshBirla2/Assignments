//import java.io.*;
import java.util.Scanner;
import java.util.Vector;

enum Designation{
    Clerk,
    Programmer,
    Manager
}

class Employee {

    static Vector<Employee> AllEmployee = new Vector<>();

int id ;
String name ;
int age ;
double salary ;
Designation designation ;

Employee(String name, int age , double salary , Designation designation){
   this.name = name ;
   this.age = age ;
   this.salary = salary ;
   this.designation = designation ; 
   AllEmployee.add(this);
}

void display(){
String toDisplay = "Name : "+name+"\nage :"+"\nSalary : "+salary+"\nDesignation : "+designation;
System.out.println(toDisplay);
}

void raiseSalary(){
    Scanner sc = new Scanner(System.in) ;
System.out.println("Name :"+name+"\nCurrent Salary : "+salary);
System.out.println("\n\n\n How much Salary you want to raise ");
  double raise = sc.nextDouble();
  salary = salary + raise ;
  sc.close();
}

}

public class Main{
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in) ;
     
    Employee e1 = new Employee("Sarvesh", 21 , 10000 , Designation.Programmer); 
    e1.display();
    e1.raiseSalary();
    e1.display();
    sc.close();
    }
}


