import java.util.HashMap;
import java.util.Map;

public class SingleNumberIII260 {
    public static int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int count = 0;
        for(int key : map.keySet()){
            int val = map.get(key);
            if(val == 1){
                nums[count] = key;
                count++;
            }
        }

        int[] res = new int[count];
        for(int i = 0; i < res.length; i++){
            res[i] = nums[i];
        }

        return res;
    }

    public static void main(String args[]){
        int[] a = {1, 2, 1, 3, 2, 5};
//        System.out.println(singleNumber(a));
        for (int i : singleNumber(a)){
            System.out.println(i);
        }
    }
}
