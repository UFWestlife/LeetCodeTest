import java.util.*;

/**
 * Created by zunwang on 2017/5/21.
 */
public class longestSubString3 {

        public static int lengthOfLongestSubstring(String s) {
            if (s.length()==0) return 0;

            char[] ch = s.toCharArray();
            if (ch.length == 1) return 1;
            int l = 1;
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < ch.length-1; i++) {
                map.put(ch[i], 1);
                for (int j = i + 1; j < ch.length; j++) {
                    if (map.containsKey(ch[j])){

                        map.clear();
                        break;
                    }
                    else {
                        map.put(ch[j], 1);
                        l =Math.max(l, j-i+1);
                    }
                }
            }
            return l;
        }
    public static int method(String s) {
        int[] map = new int[256];
        Arrays.fill(map, -1);

        int i = 0, j = 0, ans = 0;

        for(i = 0; i < s.length(); i++){
            while(j < s.length() && map[s.charAt(j)] == -1){
                map[s.charAt(j)] = 1;
                ans = Math.max(ans, j-i+1);
                j++;
            }
            map[s.charAt(i)] = -1;
        }
        return ans;
    }


    public static void main(String args[]){
        System.out.println(method("abcabcbb"));
    }
}
