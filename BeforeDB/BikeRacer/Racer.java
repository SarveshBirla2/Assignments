package BikeRacer;


public class Racer extends Thread {
    
    private String racerName ;
    private long startTime ;
    private long endTime ;
    private int speed = 0 ;
    private int distance = 0;
    private static Object lock = new Object();

    public String getRacerName(){
      return racerName;
    }
    public void setRacerName(String name){
       this.racerName = name ;
    }

    public long getStartTime(){
       return startTime;
    }
    public void setStartTime(long startTime){
     this.startTime=startTime;
    }

    public long getEndTime(){
        return endTime; 
    }
    public void setEndTIme(long endTime){
         this.endTime=endTime;
    }

    public int getSpeed(){
       return speed;
    }
    // private void setSpeed(int speed){
    //     this.speed=speed;
    // }
    public void accelarate(){
      speed = speed + 1;
    }
    public void deaccelarate(){
        if(speed>5)speed--;
    } 
    
   public void display(int rank){
    System.out.println("  "+ rank+ "   |    "+this.getName()+"   |     "+this.startTime+"    |   "+this.endTime+"    |    "+(this.endTime-this.startTime) );
   }


   public static void startRace(){
      synchronized(lock){
         lock.notifyAll();
      }
     
   }

    public void run(){

      System.out.println(this.getName() + " is ready. ");
       synchronized(lock){

         try{
            lock.wait();
         }
         catch(Exception e){
            System.out.println(e);
         }
         
       }
             this.startTime = System.currentTimeMillis();
       System.out.println(this.getName() + " started Running ");
       int mark=20;
       
       while(this.distance<BikeRace.distance){
        
       if(this.distance>mark){
        System.out.println(this.getName()+" completed " + mark + " metres mark .");
        mark=mark+20;
       }
        int randomnumber = (int)(Math.random()*3);
        switch(randomnumber){
          case 1:this.accelarate();
          break;
          case 2:this.deaccelarate();
          break;
        }
        this.distance=this.distance+speed;
        try{
          Thread.sleep(1000);
        }
        catch(Exception e){
           System.out.println(e);
        }
        
       }
       System.out.println(this.getName() + " finished Running ");
       this.endTime=System.currentTimeMillis();
    }

}