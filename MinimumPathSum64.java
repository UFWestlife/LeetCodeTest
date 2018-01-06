public class MinimumPathSum64 {
    public static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        for(int i= 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = grid[i][j];
                }else if(i == 0 && j > 0){
                    dp[i][j] = grid[i][j] + dp[i][j-1];
                }else if(i > 0 && j == 0){
                    dp[i][j] = grid[i][j] + dp[i-1][j];
                }else if(i > 0 && j > 0){
                    dp[i][j] = Math.min(dp[i][j-1]+grid[i][j], dp[i-1][j]+grid[i][j]);
                }
            }
        }

        for(int i = 0; i<dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        return dp[grid.length-1][grid[0].length-1];
    }

    public static void main(String args[]){
        int[][] grid = {{1,3,1},
                        {1,5,1},
                        {4,2,1}};
        System.out.println(minPathSum(grid));
    }
}
