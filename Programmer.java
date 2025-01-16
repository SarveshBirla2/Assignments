package employee.assignment;
public final class Programmer extends Employee{
   
    private Programmer(int EmployeeID){
        super(EmployeeID,30000,Designation.PROGRAMMER);
    }
   public void raiseSalary(){
    salary += 5000;
   };

   public static Programmer getProgrammer(int EmployeeID){
    return new Programmer(EmployeeID);
   }
}
