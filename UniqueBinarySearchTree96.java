public class UniqueBinarySearchTree96 {
    public static int numTrees(int n) {
        int[] dp = new int[n];
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 5;

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;

        for (int i  = 3; i <=n; i++){
            for (int j = 2; j <= i; j++){
                dp[i] += dp[j-1]*dp[j-i];
            }
        }

        return dp[n];
    }

    public static void main(String args[]){
        System.out.println(numTrees(3));
    }
}
