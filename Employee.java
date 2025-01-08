enum Designation{
    CLERK,
    PROGRAMMER,
    MANAGER
    
}

class Employee{

   
    
    static Employee allEmployee[] = new Employee[10];
    static int employeeCount = 0; 
    private String name ;
    private int age;
    private double salary;
    private Designation designation;
    
    Employee(String name, int age , Designation designation){
        this.name = name ;
        this.age = age;

        if(designation == Designation.CLERK){
            this.salary = 20000;
        }
        else if(designation == Designation.PROGRAMMER){
           this.salary=30000;
        }
        else if(designation == Designation.MANAGER){
            this.salary=100000;
        }

        this.designation = designation ;
        
        allEmployee[employeeCount]=this;
        employeeCount++;

    }

    static void display(){
     for(int i=0;i<Employee.employeeCount;i++){
        System.out.println("Name       : "+allEmployee[i].name);
        System.out.println("Age        : "+allEmployee[i].age);
        System.out.println("Salary     : "+allEmployee[i].salary);
        System.out.println("Desination : "+allEmployee[i].designation);
        System.out.println("---------------------------");
     }
      
    }

    static void raiseSalary(){
        for(int i=0;i<Employee.employeeCount;i++){

         if(allEmployee[i].designation == Designation.CLERK){
            allEmployee[i].salary+=2000;
         }
         if(allEmployee[i].designation == Designation.PROGRAMMER){
            allEmployee[i].salary+=5000;
         }
         if(allEmployee[i].designation == Designation.MANAGER){
            allEmployee[i].salary+=15000;
        }
         
         }
    }
}


