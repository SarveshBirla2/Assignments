package employee.assignment.utils ;
import java.util.InputMismatchException;
import employee.assignment.InvalidChoiceException;
import java.util.Scanner;
public class Menu
{
    private static int maxChoice ;

    public static int readChoice(int max, String menuDisplay){
        maxChoice = max ;
        while(true){
            System.out.println("--------------------------------------------");
            System.out.println(menuDisplay);
            System.out.println("--------------------------------------------");
            System.out.print("Enter choice :- ");
            try{
                int choice = new Scanner(System.in).nextInt();
                if(choice<1 || choice>maxChoice){
                    throw new InvalidChoiceException();
                }
                return choice;
            }
            catch(InputMismatchException e){
                System.out.println("-------------------------------------------");
                System.out.println("Please Enter number only");
                System.out.println("-------------------------------------------");

            }
            catch(InvalidChoiceException e){
                System.out.println("-------------------------------------------");
                  e.displayMessage(maxChoice);
                System.out.println("-------------------------------------------");
            }
           // return choice;
        }
    }
}