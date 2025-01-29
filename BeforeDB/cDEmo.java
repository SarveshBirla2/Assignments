class A<T extends Number>{
    public void add(T a, T b){
        System.out.println(a);
    }
}
public class cDEmo {
    public static void main(String[] args) {
        A<Integer> a1 = new A();
        a1.add(1,2);
    } 
}
