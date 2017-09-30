package LRUCache146;
import java.util.*;
/**
 * Created by Administrator on 25-May-025.
 */
public class LRUCache {

    private int capacity = 0;
    private int count = 0;
    private int[][] freq;
    private Map<Integer, Integer> map = new HashMap<>();


     public LRUCache(int capacity) {
         this.capacity = capacity;
         this.freq = new int[2][capacity];
    }

    public int get(int key) {
        if(map.containsKey(key)){
            return map.get(key);
        }else return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.put(key, map.get(key)+value);
            int i = 0;
            while(i <= capacity){
                if (freq[0][i] == key){
                    freq[1][i]++;
                    break;
                }
                i++;
            }

        }else if (count < capacity){
            map.put(key,value);
            int i = 0;
            while(i < capacity){
                if (freq[1][i] == 0){
                    freq[0][i] = key;
                    freq[1][i] = 1;
                    count++;
                    break;
                }
                i++;
            }
        }else if (count == capacity){

        }
    }
}
