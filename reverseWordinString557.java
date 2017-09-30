/**
 * Created by Administrator on 17-May-017.
 */
public class reverseWordinString557 {
    public static String reverseWords(String s) {
        char[] ch = s.toCharArray();
        int l = ch.length;
        int p1 = 0, p2 = 0;
        while (p2 <= l - 1) {
            while (ch[p2] != ' ') {
                if (p2 < l - 1) p2++;
                else break;
            }

            int start = p1, end = p2 - 1;
            if (p2 < l - 1) {
                while (start < end) {
                    char tmp = ch[start];
                    ch[start] = ch[end];
                    ch[end] = tmp;
                    start++;
                    end--;
                }
                p1 = p2 + 1;
                p2 = p1;
            } else {
                end = p2;
                while (start < end) {
                    char tmp = ch[start];
                    ch[start] = ch[end];
                    ch[end] = tmp;
                    start++;
                    end--;
                }
                break;
            }
        }
            return new String(ch);
    }

    public static void main (String args[]){
        System.out.println(reverseWords("Let's take LeetCode contest"));

    }
}
