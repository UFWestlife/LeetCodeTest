/**
 * 有 n 个不同价值的硬币排成一条线。两个参赛者轮流从左边依次拿走 1 或 2 个硬币，直到没有硬币为止。计算两个人分别拿到的硬币总价值，价值高的人获胜。
 * 请判定 第一个玩家 是输还是赢？
 */
public class CoinsInALine2 {
    public static boolean firstWillWin(int[] values) {
        int l = values.length;
        // write your code here
        // write your code here
        int[] dp = new int[l + 1];
        boolean[] flag = new boolean[l + 1];
        int sum = 0;
        for (int now : values)
            sum += now;

        return sum < 2 * MemorySearch(l, dp, flag, values);
    }

    static int MemorySearch(int n, int[] dp, boolean[] flag, int[] values) {
        int l = values.length;
        if (flag[n] == true)
            return dp[n];
        flag[n] = true;
        if (n == 0) {
            dp[n] = 0;
        } else if (n == 1) {
            dp[n] = values[l - 1];
        } else if (n == 2) {
            dp[n] = values[l - 1] + values[l - 2];
        } else if (n == 3) {
            dp[n] = values[l - 2] + values[l - 3];
        } else {
            dp[n] = Math.max(
                    Math.min(MemorySearch(n - 2, dp, flag, values), MemorySearch(n - 3, dp, flag, values)) + values[l - n],
                    Math.min(MemorySearch(n - 3, dp, flag, values), MemorySearch(n - 4, dp, flag, values)) + values[l - n] + values[l - n + 1]
            );
        }
        return dp[n];
    }
}
