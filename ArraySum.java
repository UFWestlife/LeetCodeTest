import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * This is a self-created problem
 * Given an int array and a number n,
 * return an integer list of sum by using n numbers in nums.
 */
public class ArraySum {
    static int count = 0;
    public static List<Integer> sum(int[] nums, int n){
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        search(list, nums, 0, 0, n);
        return list;
    }

    private static void search(List<Integer> list, int[] nums, int temp, int m, int n){
        if(count == n){
            if(!list.contains(temp)) list.add(new Integer(temp));
        }else{
            for (int i = m; i < nums.length; i++){
                count++;
                temp += nums[i];
                search(list, nums, temp, i+1, n);
                temp -= nums[i];
                count--;
            }
        }
    }


    public static void main(String args[]){
        int[] nums = {1,1, 2, 4};
        int target = 3;
        System.out.println(sum(nums, target));
    }
}
