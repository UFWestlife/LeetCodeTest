import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagraminString438 {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;

        int[] hash = new int[256]; //character hash

        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();

        while (right < s.length()) {
            //move right every time, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            if (hash[s.charAt(right)] >= 1) {
                count--;
            }
            hash[s.charAt(right)]--;
            right++;

            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if (count == 0) {
                list.add(left);
            }
            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length() ) {

                if (hash[s.charAt(left)] >= 0) {
                    count++;
                }
                hash[s.charAt(left)]++;
                left++;

            }
        }
        return list;
    }




    public static List<Integer> findAnagrams1(String s, String p) {
        char[] ch = p.toCharArray();
        Arrays.sort(ch);
        p = String.valueOf(ch);
        List<Integer> res = new ArrayList<>();
        if(p.length()> s.length()) return res;
        List<String> list = new ArrayList<>();
        backPerm(list, new String(), p, new boolean[p.length()]);

        for(int lo = 0, hi = lo+p.length(); hi < s.length(); lo++, hi++){
            String str = s.substring(lo, hi);
            if (list.contains(str)) res.add(lo);
        }

        return res;

    }

    //Permutation with duplicate strings, requires a sorted input!!!!
    public static void backPerm(List<String> list, String temp, String str, boolean[] used){
        if (temp.length() == str.length()){
            list.add(temp);
        }else {
            for (int i = 0; i < str.length(); i++){
                if (used[i] || i > 0 && str.charAt(i) == str.charAt(i-1) && !used[i-1]) continue;
                used[i] = true;
                temp += String.valueOf(str.charAt(i));
                backPerm(list, temp, str, used);
                used[i] = false;
                temp = temp.substring(0, temp.length()-1);
            }
        }
    }




    public static void main(String args[]){
        System.out.println(findAnagrams1("cbaebabacd", "abc"));
    }
}
