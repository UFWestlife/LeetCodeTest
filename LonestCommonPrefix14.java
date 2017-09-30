import java.util.Arrays;

/**
 * Created by Administrator on 22-May-022.
 */
public class LonestCommonPrefix14 {
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if(strs == null || strs.length == 0)
            return sb.toString();

        Arrays.sort(strs);
        char[] start = strs[0].toCharArray();

        char[] end = strs[strs.length - 1].toCharArray();

        int j = 0;
        int m = Math.min(start.length , end.length);
        if(start.length == 0){
            return sb.toString();
        }else if( start[j] == end[j]){
            sb.append(start[j]);
            j++;
            while(j < m ){
                if(start[j] == end[j]){
                    sb.append(start[j]);
                    j++;
                }else {
                    return sb.toString();
                }
            }
        }else{
            return sb.toString();
        }

        return sb.toString();
    }

    public static void main(String args[]){

        String[] strs = new String[]{
                "abcrde", "abccde", "abcsde"
        };
        System.out.println(longestCommonPrefix(strs));

        //is this dp method of lcs
    }
}
