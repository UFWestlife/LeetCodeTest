public class UniquePathesII63 {
    public static int uniquePathsWithObstacles(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = 1;
        if(grid[0][0] == 1 || grid[grid.length-1][grid[0].length-1] == 1) return 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(i == 0){
                    if(grid[i][j] == 0){
                        dp[i][j] = 1;
                    }else{
                        break;
                    }
                }else if(i > 0 && j == 0){
                    if(grid[i-1][j] == 1){// if up = 1
                        continue; //move to next column
                    }else if(grid[i][j] == 1){//if this = 1
                        continue;
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }else{
                    if(grid[i-1][j] == 1 && grid[i][j-1] == 0){//if up = 1, left = 0
                        dp[i][j] = dp[i][j-1];
                    }else if(grid[i-1][j] == 0 && grid[i][j-1] == 1){// up = 0, left = 1
                        dp[i][j] = dp[i-1][j];
                    }else if(grid[i-1][j] == 1 && grid[i][j-1] == 1){// up = 1, left = 1;
                        grid[i][j] = 1;
                    }else if(grid[i][j] == 1){
                        continue;
                    }else{
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    }
                }
            }
        }

        return dp[dp.length-1][dp[0].length-1];

    }

    public static void main(String args[]){
        int[][] grid = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        System.out.println(uniquePathsWithObstacles(grid));
    }
}
