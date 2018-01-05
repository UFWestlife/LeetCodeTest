
/*Given an unsorted integer array, find the first missing positive integer.

        For example,
        Given [1,2,0] return 3,
        and [3,4,-1,1] return 2.

        Your algorithm should run in O(n) time and uses constant space.*/


public class FirstMissingPositive41 {
    public static int firstMissingPositive(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int index = nums[start] - 1;
            if (index == start)
                start++;
            else if (index < 0 || index > end || nums[start] == nums[index]){
                nums[start] = nums[end];
                end--;
            }
            else {
                nums[start] = nums[index];
                nums[index] = index + 1;
            }
        }
        return start + 1;
    }

    public static void main(String args[]){
        int[] nums = {3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
    }
}
