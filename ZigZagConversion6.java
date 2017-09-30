/**
 * Created by Administrator on 24-May-024.
 */
public class ZigZagConversion6 {
    public static String convert(String s, int numRows) {//StringBuffer 可以理解为动态String数组
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[numRows];
        for (int i = 0; i < sb.length; i++){
            sb[i] = new StringBuffer();
        }

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < numRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = numRows-2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }

    public static void main(String args[]){
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(5/2);

    }
}
