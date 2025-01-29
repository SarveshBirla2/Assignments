package employee.assignment;
public final class Programmer extends Employee{
   
    private Programmer(int EmployeeID){
        super(EmployeeID,30000,Designation.PROGRAMMER);
    }

    public Programmer(int EmployeeID,int salary,Designation designation ,int age , String name){
        super(EmployeeID,salary,designation ,age ,name);
    }

   public void raiseSalary(){
    this.setSalary(this.getSalary()+5000);
   };

   public static Programmer getProgrammer(int EmployeeID){
    return new Programmer(EmployeeID);
   }
}
