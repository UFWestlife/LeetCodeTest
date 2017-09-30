import java.util.ArrayList;

/**
 * Created by Administrator on 16-May-016.
 */
public class reverseVowel345 {
    public static String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        int l = ch.length;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < l; i++){
            if(ch[i] == 'a' || ch[i] =='e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u'){
                arr.add(i);
            }
        }
        int size = arr.size()-1;
        char[] rev = new char[l];
        for (int i = 0; i < l; i++){
            if (!arr.contains(i)){
                rev[i] = ch[i];
            }else {
                rev[i] = ch[arr.get(size)];
                size--;
            }
        }


        return String.valueOf(rev);
    }

    public static String reverse2(String s){
        if(s == null || s.length()==0) return s;
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length()-1;
        while(start<end){

            while(start<end && !vowels.contains(chars[start]+"")){
                start++;
            }

            while(start<end && !vowels.contains(chars[end]+"")){
                end--;
            }

            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }
        return new String(chars);
    }

    public static void main(String args[]){
//        System.out.println(reverseVowels("leetcode"));
        System.out.println(reverse2("leetcode"));
    }
}
