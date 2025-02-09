package BikeRacer;

public class Countdown extends Thread {
    public void run(){
        for(int i=10;i>=1;i--){
            System.out.println("--------------------------------");
            System.out.println("Race will Begin in "+i+" Seconds");
            System.out.println("-------------------------------- ");
            try{
            Thread.sleep(1000);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }

        System.out.println(" ------------ GO ------------- ");


    }
}
