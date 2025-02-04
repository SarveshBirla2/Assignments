package employee.assignment ;

import employee.assignment.DB.DBOperation;
import employee.assignment.util.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EmployeeReader {
    public static String NameReader(){
     while(true){
        System.out.print("Enter Name :");
        String input = Input.stringInput();

        String namePattern = "[A-Z][a-zA-Z]*\\s[A-Z][a-zA-Z]*";
        Pattern p = Pattern.compile(namePattern);
        Matcher validated=p.matcher(input);

        if(validated.matches()){
            return input;
        }
       
        System.out.println("Enter Name in following format : Firstname Lastname ");
        
     }
    }


       public static int AgeReader(int min,int max ){
    while(true){
        System.out.print("Enter Age :");
        int age = Input.intInput();
         if(age<min || age > max){
            System.out.println("Enter age between "+min+" and "+max);
         }
         else return age;
    } 
      }

      public static int salaryReader(){
        while(true){
            System.out.print("Enter Salary :");
            int salary = Input.intInput();
            
             return salary ;
        } 
          }

        public static String designationReader(){
            
            HashMap<Integer,String> hmp = DBOperation.readDesignations();
            
            String menu="";
        
            for(int i=1;i<=hmp.size();i++) {
          	  menu+=i;
          	  menu+=". ";
          	  menu+=hmp.get(i);
          	  menu+="\n";
            }
            menu=menu+(hmp.size()+1)+". Other\n"+(hmp.size()+2)+". Exit\n";
            int ch=Menu.readChoice((hmp.size()+2), menu);
            if(ch==(hmp.size()+2))return null;
            if(ch==(hmp.size()+1)){
              while(true){
                System.out.print("Enter Department name : ");
                String depart = "";
                depart = Input.stringInput() ;
                if(depart != ""){
                  return depart;
                }
              }
            }
            return hmp.get(ch);    
          }



          public static String departmentReader(){

            try{        
                  
                      HashMap<Integer,String> hmp = DBOperation.readDepartments();
                    
                      String menu="";
                  
                      for(int i=1;i<=hmp.size();i++) {
                    	  menu+=i;
                    	  menu+=". ";
                    	  menu+=hmp.get(i);
                    	  menu+="\n";
                      }
                      menu=menu+(hmp.size()+1)+". Other\n"+(hmp.size()+2)+". Exit\n";
                      int ch=Menu.readChoice((hmp.size()+2), menu);
                      if(ch==(hmp.size()+2))return null;
                      if(ch==(hmp.size()+1)){
                        while(true){
                          System.out.print("Enter Department name : ");
                          String depart = "";
                          depart = Input.stringInput() ;
                          if(depart != ""){
                            return depart;
                          }
                        }
                      }
                      return hmp.get(ch);     
            }
            catch(Exception e){
                System.out.println("Error happening");
                System.out.println(e);
            }
               return null;

          }


}


