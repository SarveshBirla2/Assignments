import java.util.ArrayList;
import java.util.List;
class Covariance {
    public static void print(List<? super Integer> numbers){
       for(int i=0;i<numbers.size();i++){
        System.out.println();
       }
    }
}


public class CCIdemo {
   public static void main(String[] args) {
    List<Number> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list .add(3);
    Covariance.print(list);
   }
}
