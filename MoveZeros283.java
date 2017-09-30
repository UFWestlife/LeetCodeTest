/**
 * Created by Administrator on 25-May-025.
 */
public class MoveZeros283 {
    public static void moveZeroes(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int j = i;
            while(j < nums.length-1 && nums[j] == 0){
                    nums[j] = nums[j+1];
                    nums[j+1] = 0;
                    j++;
            }
        }
        System.out.println();
    }
    // Shift non-zero values as far forward as possible
    // Fill remaining space with zeros

    public static void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public static void main(String args[]){
        int[] nums = {0,0,1};
        moveZeroes1(nums);
    }

}
