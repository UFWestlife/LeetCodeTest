/**
 * Created by Administrator on 03-Jun-003.
 */
public class FactorialTrailingZeros172 {
    public static int trailingZeroes(int n) { // 越界
        int fac = n, count = 0;
        for (int i = 1; i < n; i++) fac *= i;
        while(fac != 0){
            if(fac % 10 == 0) count++;
            else break;
            fac /= 10;
        }
        return count;
    }

    public int trailingZeroes1(int n) {
        int s = 0;
        while (n>4){
            n = n/5;
            s = s+n;
            // s += (n/=5);
        }
        return s;
    }
    public static void main(String args[]){
        int a = 13;
        System.out.println(trailingZeroes(a));
        System.out.println(6/5);
    }
}

