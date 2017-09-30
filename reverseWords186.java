/**
 * Created by Administrator on 17-May-017.
 */
public class reverseWords186 {
    public static String reverseWords(char[] s) {
        int l = s.length;
        int count = 0;
        for (int i = 0; i < l; i++){
            if (s[i] == ' ') count++;
        }

        if (count == 0){
            return new String(s);
        } else{
            int start = 0;
            int end = l-1;
            while(start < end){
                char tmp = s[start];
                s[start] = s[end];
                s[end] = tmp;
                start++;
                end--;
            }

            int cur1 = 0, cur2 = 0;

            while(cur2 <= l-1){
                while (s[cur2] != ' ') {
                    if (cur2 < l-1) cur2++;
                    else{
                        break;
                    }
                }
                if (cur2 < l-1) {
                    int cur22 = cur2-1;
                    while(cur1 < cur22){

                        char tmp = s[cur1];
                        s[cur1] = s[cur22];
                        s[cur22] = tmp;
                        cur1++;
                        cur22--;
                    }
                    cur1 = cur2 + 1;
                    cur2++;
                }else {
                    while(cur1 < cur2){
                        char tmp = s[cur1];
                        s[cur1] = s[cur2];
                        s[cur2] = tmp;
                        cur1++;
                        cur2--;
                    }
                    break;
                }
            }
            return new String(s);
        }




    }

    public static void main(String args[]){

        System.out.println(reverseWords(" ".toCharArray()));

    }

}
