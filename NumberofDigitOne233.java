/**
 * Created by Administrator on 18-Jun-018.
 */
public class NumberofDigitOne233 {
    public static int countDigitOne(int n) {
        int count = 0;

        for (long k = 1; k <= n; k *= 10) {
            long r = n / k, m = n % k;
            // sum up the count of ones on every place k
            count += (r + 8) / 10 * k + (r % 10 == 1 ? m + 1 : 0);
        }

        return count;
    }
    public static void main (String args[]) {
        System.out.println(countDigitOne(13));
    }
}
