/**
 * Created by Administrator on 17-Jun-017.
 */
public class IslandPerimeter463 {
    public static int islandPerimeter(int[][] grid) {
        int n = grid.length;//行
        int m = grid[0].length;//列
        int c = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    int up = 1, down = 1, left = 1, right = 1;

                    if(i-1 < 0 )  left = 0;
                    else if ( grid[i-1][j] == 0) left = 0;

                    if(i+1 >= n)  right = 0;
                    else if (grid[i+1][j] == 0) right = 0;

                    if(j-1 < 0)  up = 0;
                    else if (grid[i][j-1] == 0) up = 0;

                    if(j+1 >= m)  down = 0;
                    else if (grid[i][j+1] == 0) down = 0;

                    int sum = up+down+left+right;
                    if(sum == 0) c += 4;
                    else if(sum == 1) c += 3;
                    else if(sum == 2) c += 2;
                    else if(sum == 3) c += 1;
                    else if(sum == 4) c += 0;
                }
            }
        }
        return c;
    }
    public static void main (String args[]) {
//        int[][] x = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        int[][] x ={{1,0}};
        System.out.println(islandPerimeter(x));
    }
}
