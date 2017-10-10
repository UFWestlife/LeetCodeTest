package RandomizedSet380;

import java.util.Random;

public class Test {
    public static void main(String args[]){
//        RandomizedSet r = new RandomizedSet();
//        System.out.println(r.insert(1));
//        System.out.println(r.remove(2));
//        System.out.println(r.insert(2));
//        System.out.println(r.getRandom());
//        System.out.println(r.remove(1));
//        System.out.println(r.insert(2));
//        System.out.println(r.getRandom());
        int min = 5, max = 10;
        Random random = new Random();
        for (int i = 0; i < 30; i++)
        System.out.print(random.nextInt(min+1)+max-min+", ");
        
    }
}
