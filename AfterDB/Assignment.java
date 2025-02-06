class A
{
	public void print1to10()
	{
		for(int i=1; i<=10; i++)
		{
			System.out.println("Range : "+i);
		}
	}
}
class B
{
	public void evenTill50()
	{
		for(int i=0; i<=50; i+=2)
		{
			System.out.println("Even : "+i);
		}
	}
}
class C
{
	public void fibonacciFrom1to1000()
	{
        int x = 1 , y =1 ,temp;
        while(x<=1000){
          System.out.println(x);
          temp=y;
          y=x;
          x=temp+y;
        }
	}
}
class Multithreading
{
	public static void main(String args[])
	{
        A a1 =new A();
        B b1 = new B() ;
        C c1 = new C();
        a1.print1to10();
        b1.evenTill50();
        c1.fibonacciFrom1to1000();
	}
}