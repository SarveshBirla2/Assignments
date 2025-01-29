package employee.assignment.utils;
import java.util.*;
public class Input{

  public  static int intInput(){
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

   public  static String stringInput(){
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