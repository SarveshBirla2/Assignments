package employee.assignment ;
public final class CEO extends Employee{
    private static CEO c1=null;
    private CEO(){
        super("CEO");
    }
    private CEO(int salary,String designation ,int age , String name,String department){
      super(name,salary,age,designation,department);
    }
   public static Employee getCEO(){
      if(c1==null){
        c1= new CEO();
      }
      
       return c1;
   }
   public static Employee getCEO(String name,int salary,int age,String designation,String department){
      if(c1==null){
        c1= new CEO(salary,designation,age,name,department);
      }
      return c1;
   }
}
