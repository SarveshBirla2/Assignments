package employee.assignment;
public class InvalidChoiceException extends RuntimeException{
    public InvalidChoiceException(){

    }
    public InvalidChoiceException(String msg){
     super(msg);
    }
}