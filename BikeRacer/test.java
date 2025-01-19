package BikeRacer;

public class test extends Thread {
   
    public static void main(String[] args) {
     Thread t1=new Thread(new test());
    long startTime =System.currentTimeMillis();
    try{
        Thread.sleep(2000);
    }
    catch(Exception e){

        System.out.println(e);
    }
     
    long endTime=System.currentTimeMillis();

    System.out.println(endTime-startTime);
    }
    
}


