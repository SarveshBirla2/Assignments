package employee.assignment;

public final class Manager extends Employee{
   
    private Manager(int EmployeeID){
        super(EmployeeID,100000,Designation.MANAGER);
    }

    public Manager(int EmployeeID,int salary,Designation designation ,int age , String name){
        super(EmployeeID,salary,designation ,age ,name);
    }

   public void raiseSalary(){
    this.setSalary(this.getSalary()+15000);
   };

   public static Manager getmManager(int EmployeeID){
    return new Manager(EmployeeID);
   }
}