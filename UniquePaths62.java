//问一个机器人从grid的左下角到右下角总共多少种不同的走法，只能→或者↓

public class UniquePaths62 {
    public int uniquePaths(int m, int n) {//Free debug
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j < n){
                    dp[i][j] = 1;
                }else if(i > 0 && j == 0){
                    dp[i][j] = dp[i-1][j];
                }else if(i > 0 && j < n){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        for(int i = 0; i<m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        return dp[m-1][n-1];
    }
}
