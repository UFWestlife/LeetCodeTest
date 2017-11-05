import java.util.Arrays;

/**
 * Created by Administrator on 15-May-015.
 */
public class reverseBits190 {
    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result+ (n & 1);
            n = n>>> 1;   // CATCH: must do unsigned shift
            if (i < 31) // CATCH: for last digit, don't shift!
                result =result << 1;
        }
        return result;
    }

    public static void main(String args[]){
        System.out.println(reverseBits(11));
        System.out.println(Integer.parseInt("00000000000000000000000000000001", 2));

        int n = 11;
        int count = 0;
        while(n != 0){
            String bit = Integer.toBinaryString(n);
            if((n & 1) == 1){
                count++;
            }
            n = n>>>1;
        }

        int[] a = new int[]{
                1,2,1,1,5
        };
        int b = 0;
        for (int i : a){
            if (i == 1) b++;
        }
        Arrays.sort(a);
        System.out.println(a);
    }
}
