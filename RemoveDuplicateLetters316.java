import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicateLetters316 {
    public static String removeDuplicateLetters(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);

        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(char c : ch){
            if (!map.containsKey(c)){
                map.put(c, 1);
                sb.append(c);
            }
        }


        return String.valueOf(sb);
    }

    public String removeDuplicateLettersAnswer(String s) {
        int[] cnt = new int[26];
        int pos = 0; // the position for the smallest s[i]

        for (int i = 0; i < s.length(); i++){
            cnt[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) pos = i;
            if (--cnt[s.charAt(i) - 'a'] == 0) break;
        }



        return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }

    public static void main(String args[]){
        System.out.println(removeDuplicateLetters("cbacdcbc"));
    }
}
