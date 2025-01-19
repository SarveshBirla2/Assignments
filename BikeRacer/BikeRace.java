package BikeRacer ;
import java.util.Scanner ; 

public class BikeRace{
    static int distance = 100 ;
    static int flag=0;
   public static void main(String[] args) {


    Scanner sc = new Scanner(System.in);
    while(true){
    System.out.print("Write Start to Begin :");
    try{
    String s = sc.nextLine();
    String temp = "Start";
    if(s.equalsIgnoreCase(temp)){
        break;
    }
    }
    catch(Exception e){
       System.out.println(e);
       sc.nextLine();
    }
    }

    
    Thread countdown = new Thread(new Countdown());
    countdown.start();

    try{
        countdown.join();
     }
     catch(Exception e){
        System.out.println(e);
     }

    Thread threadArray[] =new Thread[10];
    Racer racers[]=new Racer[10];
    ThreadGroup tg = new ThreadGroup("tg");
    for(int i=0;i<10;i++){
             Racer racer = new Racer();
             racers[i]=racer;
            racer.setName("Thread-" + i); // Set racer name
            threadArray[i] = new Thread(tg,racer);
    }
     
    
    for(int i=0;i<10;i++){
        threadArray[i].start();
    }
    

   while(tg.activeCount()!=0){

   }

   sortRacer.sortRacersByTime(racers);
   System.out.println(" Rank |   Thread Name  |     Start Time      |       EndTime     |   Time Taken ");
   for(int i=0;i<10;i++){
      racers[i].display(i+1);
   }
    


   }
}



// Bike Racing Game
// -----------------
// * 10 Bikers with names and their start time
// * Countdown 10, 9, 8, ...... GO
// * Every biker when reaching the finish line mark their end time and ranking
// * Display the bikers list in ascending order of their rankings 
// * Display rankings along with start time, end time and time-taken











    // while(tg.activeCount()!=0){
    //     System.out.println("1.Pause \n2.Exit");
    //     try{
    //         int temp=sc.nextInt();
    //         switch(temp){
    //             case 1 :
    //               flag=1;
    //               while(true){
    //                 System.out.println("1.Resume \n2.Exit");
    //              try{
    //                  int temp2=sc.nextInt();
    //                  switch(temp2){
    //                     case 1: flag=0;
    //                     break;
    //                     case 2:
    //                        System.exit(0);
    //                     break;
    //                  }
    //                  break;
    //              }
    //              catch(Exception e){
    //                 System.out.println(e);
    //              }
    //               }
                
    //             break;
    //             case 2 : System.exit(0);

    //             break;
    //         }
    //     }
    //     catch(Exception e){
    //         System.out.println();
    //     }

           
    // }