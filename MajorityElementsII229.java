import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElementsII229 {
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        if(n == 0 || nums == null) return list;
        if(n == 1){
            list.add(nums[0]);
            return list;
        }


        Arrays.sort(nums);
        System.out.println(n/3);
        int count = 0, temp = nums[0];
        for(int i = 0; i <= n; i++){
            if(nums[i] != temp || i == n){
                if(count > n/3){
                    list.add(temp);
                    if (i == n) continue;
                    else temp = nums[i];
                    count = 0;
                }else{
                    temp = nums[i];
                    count = 0;
                }
            }
            count++;
        }
        return list;
    }
}
