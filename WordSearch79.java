/*
Given a 2D board and a word, find if the word exists in the grid.

        The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

        For example,
        Given board = [
        ['A','B','C','E'],
        ['S','F','C','S'],
        ['A','D','E','E']
        ]

        word = "ABCCED", -> returns true,
        word = "SEE", -> returns true,
        word = "ABCB", -> returns false.

*/


public class WordSearch79 {
    static boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        //this kind of Matrix all direction scanning problems, building a used array first
        visited = new boolean[board.length][board[0].length];

        //traverse all element (may start from any element) in matrix with btSearch
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(char[][]board, String word, int i, int j, int index){
        if(index == word.length()){
            return true;
        }

        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }

        visited[i][j] = true;// this element is used in current invoke
        if(search(board, word, i-1, j, index+1) ||
                search(board, word, i+1, j, index+1) ||
                search(board, word, i, j-1, index+1) ||
                search(board, word, i, j+1, index+1)){
            return true;
        }

        visited[i][j] = false;
        return false;
    }
}
