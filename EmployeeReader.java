package employee.assignment ;

import java.util.InputMismatchException;
import java.util.Scanner;
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





      public static int EmployeeIdReader(){
             int EmployeeID=-1;
        Scanner sc = new Scanner(System.in);
            while(EmployeeID==-1){
           
           while(true){    
             try{
                
                    System.out.print(" Enter the EmployeeId :");
                    EmployeeID=sc.nextInt();
                    if(EmployeeID<=0) throw new InvalidChoiceException("Enter Valid Employee ID greater than 0 ");
                    else break;
               }
            catch(InputMismatchException e){
                System.out.println("-------------------------------------------");
                System.out.println("Enter the Correct EmployeeID in Integer Only !!");
                System.out.println("-------------------------------------------");
                sc.nextLine();
            }
            catch(InvalidChoiceException e){
                System.out.println("-------------------------------------------");
                System.out.println(e.getMessage());
                System.out.println("-------------------------------------------");
                sc.nextLine();
            }
           }   
           
            if(EmployeeMap.Employees.containsKey(EmployeeID)){
                System.out.println("-------------------------------------------");
                System.out.println(" Employee ID Already exist, enter a different Employee ID");
                System.out.println("-------------------------------------------");
                EmployeeID=-1;
            }

         
        }
        return EmployeeID ;
    
      }


}

class Input{
    static int intInput(){
        while(true){
              try{
                int input = new Scanner(System.in).nextInt();
                return input;
                }
                catch(InputMismatchException e){
                    System.out.println("Enter the Integer Input Only ");
                }

        }
    }

    static String stringInput(){
        while(true){
            try{
              String input = new Scanner(System.in).nextLine();
              return input;
              }
              catch(InputMismatchException e){
                  System.out.println("Enter the String Input Only ");
              }

      }
    }

}
