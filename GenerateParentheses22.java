import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 19-Jun-019.
 */
public class GenerateParentheses22 {
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public static void backtrack(List<String> list, String str, int left, int right, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(left < max)
            backtrack(list, str+"(", left+1, right, max);
        if(right < left)
            backtrack(list, str+")", left, right+1, max);
    }

    public static void main (String args[]){
        System.out.println(generateParenthesis(3));
        String s = "adb";

    }
}
