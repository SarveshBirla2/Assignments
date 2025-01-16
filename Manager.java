package employee.assignment;

public final class Manager extends Employee{
   
    private Manager(int EmployeeID){
        super(EmployeeID,100000,Designation.MANAGER);
    }
   public void raiseSalary(){
    salary += 15000;
   };

   public static Manager getmManager(int EmployeeID){
    return new Manager(EmployeeID);
   }
}