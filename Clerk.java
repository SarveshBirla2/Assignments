package employee.assignment ;
public final class Clerk extends Employee{
   
    private Clerk(int EmployeeID){
        super(EmployeeID,20000,Designation.CLERK);
    }
   public void raiseSalary(){
    this.setSalary(this.getSalary()+2000);
   };
    
   public static Clerk getClerk(int EmployeeID){
    return new Clerk(EmployeeID);
   }
}