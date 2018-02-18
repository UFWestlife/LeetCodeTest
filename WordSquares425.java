import java.util.ArrayList;
import java.util.List;

public class WordSquares425 {
    public static List<List<String>> wordSquares(String[] words) {// My method will lead to a TLE
        List<List<String>> res = new ArrayList<>();
        if(words.length == 0) return res;
//        if(words.length < words[0].length()) return res;
        check(res, new ArrayList<>(), words);
        return res;
    }


    private static void check(List<List<String>> list, List<String> temp, String[] words){
        if(temp.size() == words[0].length()){
            if(isValid(temp)) list.add(new ArrayList<>(temp));
        }else{
            for(int i = 0; i < words.length; i++){
                if (temp.size() > 0){
                    if (words[i].charAt(0) != temp.get(0).charAt(temp.size())) continue;
                }
                temp.add(words[i]);
                check(list, temp, words);
                temp.remove(temp.size()-1);
            }
        }
    }


    private static boolean isValid(List<String> temp){
        char[][] ch = new char[temp.size()][temp.size()];
        for(int i = 0; i < temp.size(); i++){
            ch[i] = temp.get(i).toCharArray();
        }
        for(int i = 0; i < temp.size(); i++){
            for(int j = 0; j < temp.size(); j++){
                if(ch[i][j] != ch[j][i]) return false;
            }
        }
        return true;
    }

    /*
class Node{
        Node[] nodes;
        String word;
        Node(){
            this.nodes = new Node[26];
            this.word = null;
        }
    }
    void add(Node root, String word){
        Node node = root;
        for (char c : word.toCharArray() ) {
            int idx = c-'a';
            if (node.nodes[idx] == null) node.nodes[idx] = new Node();
            node = node.nodes[idx];
        }
        node.word = word;
    }
    void helper(int row, int col, int len, Node[] rows, List<List<String>> ret) {
        if ( (col == row) && (row == len) ) { // last char
            List<String> res = new ArrayList<String>();
            for (int i=0; i<len; i++) {
                res.add(new String(rows[i].word) );
            }
            ret.add( res );
        } else { // from left to right and then go down to the next row
            if ( col < len  ) { // left to right first
                Node pre_row = rows[row];
                Node pre_col = rows[col];
                for (int i=0; i<26; i++) { // find all the possible next char
                    if ( (rows[row].nodes[i] != null) && (rows[col].nodes[i] != null) ) {
                        rows[row] = rows[row].nodes[i];
                        if (col != row) rows[col] = rows[col].nodes[i];
                        helper(row, col+1, len, rows, ret);
                        rows[row] = pre_row;
                        if (col != row) rows[col] = pre_col;
                    }
                }
            } else { // reach the end of column, go to the next row
                helper(row+1, row+1, len, rows, ret);
            }
        }
    }
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ret = new ArrayList();
        if (words==null || words.length==0) return ret;
        Node root = new Node();
        int len = words[0].length();
        for (String word: words) add(root, word);
        Node[] rows = new Node[len];
        for (int i=0; i<len; i++) rows[i]=root;
        helper(0, 0, len, rows, ret);
        return ret;
    }
     */

    public static void main(String argsp[]){
        List<String> list = new ArrayList<>();
        list.add("ball");
        list.add("area");
        list.add("lead");
        list.add("lady");
//        System.out.println(isValid(list));
        String [] words = {"momy","oooo","yoyo"};
        System.out.println(wordSquares(words));
    }
}
