/**
 * Created by Administrator on 05-Jun-005.
 */
public class MyPow50 {
    public static double myPow(double x, int n) {
        double carry = x;
        if(n == 0) return 1;
        if(n == 1) return x;
        boolean zf;
        if(n > 0) zf = true;
        else zf = false;
        n = Math.abs(n);
        for(int i = 1; i < n; i++){
            x *= carry;
        }
        if(zf == false) return (double)1/x;
        return x;
    }

    public static double myPow2(double x, int n){
        if(n == 0) {
            return 1;
        }
        if(x == 0) {
            return 0;
        }
        if( n < 0) {
            if( n == Integer.MIN_VALUE) {
                n++; // Make -2147483648 to -2147483647
                if(x < 0) {
                    x = -x; //we made n odd so need to update sign
                }
            }
            n = -n;
            x = 1/x;
        }
        if(n % 2 == 0) {
            return myPow(x*x, n/2);
        }
        else {
            return x * myPow(x*x, n/2);
        }
    }
    public static void main (String args[]){
        System.out.println(myPow2(34.00515, -3));
    }
}
