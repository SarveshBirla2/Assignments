package employee.assignment ;
public final class CEO extends Employee{
    private static CEO c1=null;
    private CEO(int EmployeeID){
        super(EmployeeID,200000,Designation.CEO);
    }
    private CEO(int EmployeeID,int salary,Designation designation ,int age , String name){
      super(EmployeeID,salary,designation ,age ,name);
    }
   public void raiseSalary(){
    this.setSalary(this.getSalary()+30000);
   };
   public static Employee getCEO(int EmployeeID){
      if(c1==null){
        c1= new CEO(EmployeeID);
      }
      
       return c1;
   }
   public static Employee getCEO(int EmployeeID,int salary,Designation designation ,int age , String name){
      if(c1==null){
        c1= new CEO(EmployeeID, salary, designation, age, name);

      }
      return c1;
   }
}