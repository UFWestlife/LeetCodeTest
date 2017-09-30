package LRUCache146;

/**
 * Created by Administrator on 25-May-025.
 */
public class Test {
    public static void main(String args[]){
        LRUCache cache = new LRUCache(3);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(2,2);
        cache.put(3,3);

    }
}
