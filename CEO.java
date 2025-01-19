package employee.assignment ;
public final class CEO extends Employee{
    private static CEO c1=null;
    private CEO(int EmployeeID){
        super(EmployeeID,200000,Designation.CEO);
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
}