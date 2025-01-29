package Calculator;
import java.util.Scanner;
import java.lang.reflect.*;
import java.lang.*;
//import Calculator.Calculator;
public class Calculation {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter class name : ");
        String className=sc.nextLine();
        Class c = Class.forName("Calculator."+className);
        Object obj = c.newInstance();

        Method methods[]=c.getDeclaredMethods();
        
        
        for(int i=0;i<methods.length;i++){
            System.out.println(methods[i].getName());
        }
        System.out.print("Choose the operation :");
        String methodName = sc.next();

        System.out.print("Enter Param 1 :");
        int a = sc.nextInt();

        System.out.print("Enter Param 2 :");
        int b = sc.nextInt();
        
      Method m = c.getDeclaredMethod(methodName,int.class,int.class); 

        System.out.println(m.invoke(obj,a,b));






    }
}
