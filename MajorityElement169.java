/**
 * Created by Administrator on 21-May-021.
 */
import java.util.*;
public class MajorityElement169 {
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            if (map.containsKey(i)) map.put(i, map.get(i)+1);
            else map.put(i, 1);
        }

        int key = 0;
        for(Integer getKey: map.keySet()){
            if(map.get(getKey).equals(1)){
                key = getKey;
            }
        }
        return key;
    }
    public static void main (String args[]){
        int[] a ={0,1,1};

        System.out.println(majorityElement(a));
    }
}
