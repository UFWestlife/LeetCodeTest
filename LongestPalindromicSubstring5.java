/**
 * Created by Administrator on 25-May-025.
 */
public class LongestPalindromicSubstring5 {
    public static String longestPalindrome(String s) {
        if(s.length() == 0) return null;
        if(s.length() == 1) return s;
        char[] ch = s.toCharArray();
        int l = ch.length;
        int count = 0;
        for(int i = 0; i < l; i++){
            if (ch[0] == ch[i]) count++;
        }
        if(count == l) return s;

        int start = 0, length = 0;

        for(int i = 0; i < l; i++){
            for(int j = i+1; j < l; j++){
                if(ch[i] == ch[j]){
                    length = Math.max(length, j-i+1);
                    if(length == j-i+1) start = i;
                    break;
                }
            }
        }
        char[] result = new char[length];
        for(int i = 0; i < length; i++){
            result[i] = ch[start];
            start++;
        }
        return new String(result);
    }

    public static String longestPalindrome1(String s) {
        int length=s.length();
        int start=0,end=0;
        int len=1;
        for(int i=1;i<length-1;i++){
            int l,r;
            l=i-1;
            r=i+1;
            while(l>=0&&r<length&&s.charAt(l)==s.charAt(r)){
                l--;
                r++;
            }
            if(len<(r-l+1-2)){
                len=r-l+1-2;
                start=++l;
                end=--r;
            }

        }

        for(int i=1;i<length;i++){
            int l,r;
            l=i-1;
            r=i;
            while(l>=0&&r<length&&s.charAt(l)==s.charAt(r)){
                l--;
                r++;
            }
            if(len<(r-l+1-2)){
                len=r-l+1-2;
                start=++l;
                end=--r;
            }

        }

        return s.substring(start,end+1);
    }

    public static void main(String args[]){
        System.out.println(longestPalindrome("abcdaa"));
        System.out.println(longestPalindrome1("abcdaa"));
    }
}
