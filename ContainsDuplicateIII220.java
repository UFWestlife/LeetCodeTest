import java.util.Arrays;

public class ContainsDuplicateIII220 {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Arrays.sort(nums);
        if(nums.length < 2 || nums == null) return false;
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j <= i+k && j < nums.length; j++){
                if(Math.abs(nums[i] - nums[j]) <= t){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String args[]){
        int[] a = {1,3,1};
        System.out.println(containsNearbyAlmostDuplicate(a, 1, 1));
    }
}
