import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 20-Jun-020.
 */
public class WordBreak139 {
    private List<String> cnm;
    private List<String> result = new ArrayList<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        cnm = wordDict;
        return find(s);
    }

    public boolean find(String str){
        if(cnm.contains(str)) return true;
        else{
            if (str.length() == 1) return false;
            else{
                for (int i = 1; i < str.length(); i++){
                    if (find(str.substring(0, i)) && find(str.substring(i, str.length()))) return true;
                }
                return false;
            }
        }
    }
}

