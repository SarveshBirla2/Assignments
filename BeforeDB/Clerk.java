package employee.assignment ;
public final class Clerk extends Employee{
   
    private Clerk(int EmployeeID){
        super(EmployeeID,20000,Designation.CLERK);
    }
    public Clerk(int EmployeeID,int salary,Designation designation ,int age , String name){
        super(EmployeeID,salary,designation ,age ,name);
    }
   public void raiseSalary(){
    this.setSalary(this.getSalary()+2000);
   };
    
   public static Clerk getClerk(int EmployeeID){
    return new Clerk(EmployeeID);
   }
}