/**
 * 有 n 个硬币排成一条线。两个参赛者轮流从右边依次拿走 1 或 2 个硬币，直到没有硬币为止。拿到最后一枚硬币的人获胜。
 * 请判定 第一个玩家 是输还是赢？
 */
public class CoinsInALine1 {
    public static boolean firstWillWin(int n) {
        // write your code here
        // write your code here
        if (n == 0)
            return false;
        else if (n == 1)
            return true;
        else if (n == 2)
            return true;

        boolean []dp = new boolean[n+1];
        dp[0] = false;
        dp[1] = true;
        dp[2] = true;
        for (int i = 3; i <= n; i++)
            dp[i] = !dp[i - 1] || !dp[i - 2];

        return dp[n];
    }
}
