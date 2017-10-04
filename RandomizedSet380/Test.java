package RandomizedSet380;

public class Test {
    public static void main(String args[]){
        RandomizedSet r = new RandomizedSet();
        System.out.println(r.insert(1));
        System.out.println(r.remove(2));
        System.out.println(r.insert(2));
        System.out.println(r.getRandom());
        System.out.println(r.remove(1));
        System.out.println(r.insert(2));
        System.out.println(r.getRandom());
    }
}
