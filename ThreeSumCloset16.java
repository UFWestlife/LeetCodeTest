import java.util.Arrays;

/**
 * Created by Administrator on 19-Jun-019.
 */
public class ThreeSumCloset16 {
    public static int threeSumClosest(int[] num, int target) {
        int result = num[0] + num[1] + num[num.length - 1];
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1, end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }
    public static void main (String args[]) {
        int[] a = {-1, 2, 1, -4}; int b = -1;
        System.out.println(threeSumClosest(a, b));
    }
}
