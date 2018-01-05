import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordBreakII140 {
    // Back track method
    static HashMap<String,List<String>> map = new HashMap<String,List<String>>();
    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() == 0) {
            return res;
        }
        if(map.containsKey(s)) {
            return map.get(s);
        }
        if(wordDict.contains(s)) {
            res.add(s);
        }
        for(int i = 1 ; i < s.length() ; i++) {
            String t = s.substring(i);
            if(wordDict.contains(t)) {
                List<String> temp = wordBreak(s.substring(0 , i) , wordDict);
                if(temp.size() != 0) {
                    for(int j = 0 ; j < temp.size() ; j++) {
                        res.add(temp.get(j) + " " + t);
                    }
                }
            }
        }
        map.put(s , res);
        return res;
    }


    //DP method
    static HashMap<Integer, List<String>> dp = new HashMap<>();

    public static List<String> wordBreak2(String s, List<String> wordDict) {
        int maxLength = -1;
        for(String ss : wordDict) maxLength = Math.max(maxLength, ss.length());
        return addSpaces(s, wordDict, 0, maxLength);
    }

    private static List<String> addSpaces(String s, List<String> wordDict, int start, int max){
        List<String> words = new ArrayList<>();
        if(start == s.length()) {
            words.add("");
            return words;
        }
        for(int i = start + 1; i <= max + start && i <= s.length(); i++){
            String temp = s.substring(start, i);
            if(wordDict.contains(temp)){
                List<String> ll;
                if(dp.containsKey(i)) ll = dp.get(i);
                else ll = addSpaces(s, wordDict, i, max);
                for(String ss : ll) words.add(temp + (ss.equals("") ? "" : " ") + ss);
            }

        }
        dp.put(start, words);
        return words;
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
