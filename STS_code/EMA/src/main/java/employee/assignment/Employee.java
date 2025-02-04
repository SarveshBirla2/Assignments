package employee.assignment;
import org.bson.Document;

import com.mongodb.client.FindIterable;

import EMA.EmployeeManagementApp;
import employee.assignment.DB.*;
import employee.assignment.util.Input;
import employee.assignment.util.Menu;
public abstract class Employee {
    private String name;
    private int salary;
	private int age;
	private String designation;
	private String  department;
	Employee(String name,int salary,int age,String designation,String department){
		this.name = name ;
		this.salary = salary ;
		this.age = age;
		this.designation = designation;
		this.department = department ;
		DBOperation.save(this);
		EmployeeManagementApp.empCount ++ ;	
	}
	Employee(String designation){
		
	    this.getDetails();
	    
		this.designation = designation;
		EmployeeManagementApp.empCount ++ ;	
		DBOperation.save(this);
		
	}
	

	public String getName() {
		return this.name;
	}
	public String getDesignation() {
		return this.designation;
	}
	public String getDepartment() {
		return this.department;
	}
	public int getSalary() {
		return this.salary;
	}
	public int getAge() {
		return this.age;
	}
	private void getDetails() {
		
	  this.department = EmployeeReader.departmentReader();
	  this.name = EmployeeReader.NameReader();
	  this.age = EmployeeReader.AgeReader(20, 60);
	  this.salary = EmployeeReader.salaryReader();
	  
	  
	}
	
	public static int getEmployeeCount() {
		return DBOperation.giveEmployeecount();
	}
	
	
	public static void raiseSalary() {
		System.out.print("Enter Employee ID whose salary is to be raised : ");
        int EmpID = Input.intInput();
        Document d = DBOperation.readById(EmpID);
        if(d!=null) {
        	
            System.out.println("---------------------------------------");
            System.out.println("Employee Name : "+ d.getString("name"));
            System.out.println("Current Salary : "+d.getInteger("salary"));
            System.out.println("---------------------------------------");

          System.out.print("Enter the Appraisal Amount : ");
          int increase = Input.intInput();
          int increasedSalary = increase + d.getInteger("salary");
          DBOperation.updateById(EmpID,"salary", increasedSalary);
        }
        else{
            System.out.println("--------------------------------");
            System.out.println("Employee ID :"+EmpID+" does not exist ");
            System.out.println("--------------------------------");
        } 
	}
	
	public static void display() {
		   String menu=" Sort By : \n1. ID\n2. Name \n3. Designation  \n4. Age \n5. Salary\n6. Exit" ;
		   int ch = Menu.readChoice(6, menu);
		   FindIterable<Document> itr = null;
		   switch(ch) {
		   case 1: itr = DBOperation.read("_id");
			   break;
		   case 2: itr = DBOperation.read("name");
			   break;
		   case 3: itr = DBOperation.read("designation");
			   break;
		   case 4: itr = DBOperation.read("age");
			   break;
		   case 5: itr = DBOperation.read("salary");
			   break;
		   case 6: return ;
			   
		   }
		   
	      System.out.println("---------------------------------------------------------------");
	   System.out.printf("%-10s %-15s %-5s %-10s %-20s %-15s%n", "EID", "Name", "Age", "Salary", "Department", "Designation");
	      System.out.println("---------------------------------------------------------------");
	      
	      
		  for(Document d : itr) {
			  int id = d.getInteger("_id");
			  String name = d.getString("name");
			  int age = d.getInteger("age");
			  int salary = d.getInteger("salary");
			  String designation = d.getString("designation");
			  String department = d.getString("department");
			  
			  System.out.printf("%-10s %-15s %-5s %-10s %-15s %-15s%n",id,name,age,salary,designation,department);
			    
		  }
	       System.out.println("---------------------------------------------------------------");
	}


	public static void search() {
		System.out.print("Enter Employee ID to be Searched : ");
        int EmpID = Input.intInput();
        Document d = DBOperation.readById(EmpID);
        if( d!=null ){
            System.out.println("---------------------------------------");
            System.out.println("EID : "+ d.getInteger("_id"));
            System.out.println("Name : "+d.getString("name"));
            System.out.println("Age : "+ d.getInteger("age"));
            System.out.println("Salary : "+ d.getInteger("salary"));
            System.out.println("Department : "+ d.getString("department"));
            System.out.println("Designation : "+ d.getString("designation"));
            System.out.println("---------------------------------------");
        }
        else{
            System.out.println("--------------------------------");
            System.out.println("Employee ID :"+EmpID+" does not exist ");
            System.out.println("--------------------------------");
        }
	}


    public static void delete() {
    	System.out.print("Enter Employee ID to be Deleted : ");
        int EmpID = Input.intInput();
        Document d =  DBOperation.readById(EmpID);
        if(d!=null){
            if(d.getString("designation").equals("CEO")){
                System.out.println("--------------------------------");
                System.out.println("Cannot Delete CEO ");
                System.out.println("--------------------------------");
                return;
            }
            System.out.println("---------------------------------------");
            System.out.println("EID : "+ d.getInteger("_id"));
            System.out.println("Name : "+d.getString("name"));
            System.out.println("Age : "+ d.getInteger("age"));
            System.out.println("Salary : "+ d.getInteger("salary"));
            System.out.println("Department : "+ d.getString("department"));
            System.out.println("Designation : "+ d.getString("designation"));
            System.out.println("---------------------------------------");
            
            String menu ="Do You really want to Delete Above Employee \n1 .Yes \n2 .No";
            int ch=Menu.readChoice(2, menu);
            if(ch==1){
              DBOperation.delete(EmpID);
              System.out.println(" Deleted !! ");
            }
        }
        else{
            System.out.println("--------------------------------");
            System.out.println("Employee ID :"+EmpID+" does not exist ");
            System.out.println("--------------------------------");
        }
    }
}
