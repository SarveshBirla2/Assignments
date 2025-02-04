package employee.assignment;

public abstract class EmployeeFactory {
	
	
	     
  public static Employee getEmployee() {
	  
	  String designation = EmployeeReader.designationReader();
	  if(designation == null )return null;
	  
	  switch(designation) {
	  case "CEO": 
		  return CEO.getCEO();  
	  case "Clerk":
		   return new Clerk();
	  case "Manager":
		   return new Manager();
		   
	  default : 
		  return new Other(designation);
		 
	  }
  }
}
