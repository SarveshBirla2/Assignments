
package JSONdemo ;
public class InvalidChoiceException extends RuntimeException
{
    public InvalidChoiceException()
    {

    }
    public InvalidChoiceException(String msg)
    {
        super(msg);
    }
    public void displayMessage(int maxChoice)
    {
       System.out.println("Enter a valid choice between 1 and "+maxChoice);
    }
}