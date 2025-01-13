package employee.assignment;
public class CheckAge extends RuntimeException{
    public CheckAge(){

    }
    
    public CheckAge(String msg){
        super(msg);
    }
}
