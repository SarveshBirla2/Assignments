package employee.assignment ;
public final class Clerk extends Employee{
   
    public Clerk(int EmployeeID){
        super(EmployeeID,20000,Designation.CLERK);
    }
   public void raiseSalary(){
    salary += 2000;
   };
}