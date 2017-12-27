import java.util.ArrayList;
import java.util.List;

public class WordBreakII140 {
    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list = new ArrayList<>();
        search(list, wordDict, "", "", s, 0);
        return list;
    }


    private static void search(List<String> list, List<String> dic, String str, String temp, String s, int m){
        if (m == s.length()){
            list.add(str);
        }else{
            for (int i = m; i < s.length(); i++){
                temp += s.substring(i,i+1);
                if (dic.contains(temp)){
                    str += temp;
                    str += " ";
//                    if (i != s.length()-1){
//                        str += " ";
//                    }
                    search(list, dic, str, "", s, i+1);
                    str = str.substring(0, str.length()-temp.length()-1);
                    i -= temp.length();

                }
            }
        }
    }



    public static void main(String args[]){
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("and");
        wordDict.add("sand");

        String s = "catsanddog";
        System.out.println(wordBreak(s, wordDict));


    }
}
