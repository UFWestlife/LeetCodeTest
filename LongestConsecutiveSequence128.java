import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence128 {
    public static int longestConsecutive(int[] nums) {
        int max = 0;

        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            int count = 1;

            // look left
            int num = nums[i];
            while (set.contains(num-1)) {
                num--;
                count++;
                set.remove(num);
            }

            // look right
            num = nums[i];
            while (set.contains(num+1)) {
                num++;
                count++;
                set.remove(num);
            }

            max = Math.max(max, count);
        }

        return max;
    }
    public static void main(String args[]){
        int[] a = {2,2,2,2,2};
        System.out.println(longestConsecutive(a));
    }
}
