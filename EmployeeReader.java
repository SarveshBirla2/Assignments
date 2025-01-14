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
