/**
 * 有 n 个硬币排成一条线，每一枚硬币有不同的价值。两个参赛者轮流从任意一边取一枚硬币，知道没有硬币为止。计算拿到的硬币总价值，价值最高的获胜。
 * 请判定 第一个玩家 是输还是赢？
 */
public class CoinsInALine3 {
    public static boolean firstWillWin(int[] values) {
        // write your code here
        int n = values.length;
        int [][]dp = new int[n + 1][n + 1];
        boolean [][]flag =new boolean[n + 1][n + 1];
        int[][] sum = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {// initialise
            for (int j = i; j < n; j++) {
//                sum[i][j] = i == j ? values[j] : sum[i][j-1] + values[j];
                if (i == j) sum[i][j] = values[j];
                else sum[i][j] = sum[i][j-1] + values[j];
                System.out.print(sum[i][j]+"\t");
            }
            System.out.println();
        }

        int allsum = 0;
        for(int now : values)
            allsum += now;

        System.out.println("\n"+allsum);

        return allsum/2 < MemorySearch(0, n - 1, dp, flag, values, sum);
    }
    static int MemorySearch(int left, int right, int [][]dp, boolean [][]flag, int []values, int [][]sum) {
        if(flag[left][right])
            return dp[left][right];

        flag[left][right] = true;

        if(left > right) {
            dp[left][right] = 0;
        } else if (left == right) {
            dp[left][right] = values[left];
        } else if(left + 1 == right) {
            dp[left][right] = Math.max(values[left], values[right]);
        } else {
            int cur = Math.min(MemorySearch(left+1, right, dp, flag, values, sum),
                                MemorySearch(left,right-1, dp, flag, values, sum));
            dp[left][right] = sum[left][right] - cur;
        }

        return dp[left][right];
    }

    public static void main(String args[]){
        int[] values = {5,3,1,2,6};
        firstWillWin(values);

        int x = 0;

        int a[] = {1,2,3};

        a[x++] = (x++) + 2;

        for (int xb : a)
        System.out.print(xb);
    }
}

