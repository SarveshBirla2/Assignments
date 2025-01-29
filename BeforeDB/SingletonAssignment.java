class A 

{  
	private static A a1= null;
	private static boolean a= false ;
	private static boolean b = false ;
	 A(){
		System.out.println(a+" "+b);
         if(!b && this instanceof B){
			b =true;
		 }
		 else if(!a && this instanceof A){
			System.out.println("A object created");
			A.a = true;
		 }
		 else {
			throw new NullPointerException();
		 }
		 System.out.println(a+" "+b);
		 
	}
    
	public static A getObject(){
		if(a1==null){
			a1=new A();
		}

       return a1;
	}
}

class B extends A
{   
	
	public static final B b1 = new B();
	private B(){

	}
	public static B getObject(){
      return b1;
	}
}
 
public class SingletonAssignment
{
	// static{
	// 	try{
	// 		Class.forName("A");
	// 	}
	// 	catch(Exception e){
	// 		System.out.println(e);
	// 	}
	// }
	public static void main(String args[])
	{    
		A a1=new A();
		//A a3 = new A();
		A a2=A.getObject();
		System.out.println(a1);
		System.out.println(a2);
	}
}
 
// * Should be able to create only 1 object of A class
// * Should be able to create only 1 object of B class
// * If tried to create more than 1 object of any of these two classes, then exception should be raised
