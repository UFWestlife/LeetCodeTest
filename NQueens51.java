import java.util.ArrayList;
import java.util.List;

public class NQueens51 {
    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';

        List<List<String>> res = new ArrayList<>();
        dfs(res, board, 0, n);
        return res;
    }

    private static void dfs(List<List<String>> list, char[][] board, int col, int n){
        if(col == n){
            list.add(build(board));
            return;
        }

        for(int i = 0; i < n; i++){
            if(check(board, i, col)){
                board[i][col] = 'Q';
                dfs(list, board, col+1, n);
                board[i][col] = '.';
            }
        }
    }


    private static boolean check (char[][] board, int x, int y){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < y; j++){
                if(board[i][j] == 'Q' && (i == x || j == y  || Math.abs(i-x) == Math.abs(j-y)))
                    return false;
            }
        }
        return true;
    }

    private static List<String> build (char[][] board){
        List<String> res = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    public static void main(String args[]){
        List<List<String>> res = solveNQueens(4);
        for (List<String> temp : res){
            for (String str : temp){
                System.out.println(str);
            }
            System.out.println();
        }

    }
}
