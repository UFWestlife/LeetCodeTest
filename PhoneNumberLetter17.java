import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Administrator on 17-Jun-017.
 */
public class PhoneNumberLetter17 {
    public static List<String> letterCombinations(String digits) {
//        LinkedList<String> ans = new LinkedList<String>();
        Queue<String> ans = new LinkedList<>();
        if(digits.length() == 0) return (List<String>) ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return (List<String>)ans;
    }
    public static void main (String args[]){
        System.out.println(letterCombinations("234"));
    }
}
