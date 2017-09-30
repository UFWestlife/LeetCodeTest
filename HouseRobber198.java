/**
 * Created by zunwang on 2017/5/29.
 */
public class HouseRobber198 {
    public static int rob(int[] nums) {
        int[][] dp = new int[nums.length + 1][2];
        for (int i = 1; i <= nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = nums[i - 1] + dp[i - 1][0];
        }
        return Math.max(dp[nums.length][0], dp[nums.length][1]);
    }

    public static int rob1(int[] nums) {
        int prevNo = 0;
        int prevYes = 0;
        for (int n : nums) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = n + temp;
        }
        return Math.max(prevNo, prevYes);
    }
    public static void main(String args[]){
        int[] a = {7,1,3,2,4,5};
        System.out.println(rob(a));
    }
}
