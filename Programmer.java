package employee.assignment;
public final class Programmer extends Employee{
   
    public Programmer(int EmployeeID){
        super(EmployeeID,30000,Designation.PROGRAMMER);
    }
   public void raiseSalary(){
    salary += 5000;
   };
}
