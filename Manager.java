package employee.assignment;

public final class Manager extends Employee{
   
    public Manager(int EmployeeID){
        super(EmployeeID,100000,Designation.MANAGER);
    }
   public void raiseSalary(){
    salary += 15000;
   };
}