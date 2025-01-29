package employee.assignment;
import java.util.*;

import employee.assignment.utils.Menu;
public class Display {
    public static void display(){
     

          if (EmployeeMap.empCount == 0){
                    System.out.println("No Employee Present to Display");
                    return ;
                }
         
        int choice = Menu.readChoice(5,"1. EmployeeID\n2. Name\n3. Age\n4. Salary\n5. Designation" );
        Collection<Employee> coll= EmployeeMap.Employees.values();
        List<Employee> list=new ArrayList<Employee>(coll) ;
        switch(choice){
           case 1:
            break;
           case 2 :
           Collections.sort(list,EmployeeComparator.nameComparator());
           break;
           case 3 :
           Collections.sort(list,EmployeeComparator.ageComparator());
           break;
           case 4:
           Collections.sort(list,EmployeeComparator.salaryComparator());
           break;
           case 5:
           Collections.sort(list,EmployeeComparator.designationComparator());
           break;
        }

        for(Employee e:list){
            e.display();
        }
    }
}


class EmployeeComparator{
    public static Comparator<Employee> nameComparator(){
        return new Comparator<Employee>() {
            public int compare(Employee e1, Employee e2){
                return e1.getName().compareTo(e2.getName());
            }
        };
    }
    public static Comparator<Employee> ageComparator(){
        return new Comparator<Employee>() {
            public int compare(Employee e1,Employee e2){
                return Integer.valueOf(e1.getAge()).compareTo(e2.getAge());
             } 
        };
       
    }

    public static Comparator<Employee> salaryComparator(){
        return new Comparator<Employee>() {
            public int compare(Employee e1,Employee e2){
                return Integer.valueOf(e1.getSalary()).compareTo(e2.getSalary());
             } 
        };
       
    }

    public static Comparator<Employee> designationComparator(){
         return new Comparator<Employee>() {
            public int compare(Employee e1,Employee e2){
                return e1.getDesignation().compareTo(e2.getDesignation());
            }
         };
    }
}
