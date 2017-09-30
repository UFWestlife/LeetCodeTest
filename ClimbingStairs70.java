/**
 * Created by Administrator on 23-May-023.
 */
public class ClimbingStairs70 {

    public static int climbStairs(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs(0, n, memo);
    }
    public static int climb_Stairs(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        return memo[i];
    }


    public static int climbStairs1(int n) {
        int a = 1, b = 1;
        while (n-- > 0)
            b = b+a;
            a = b;

//            a = (b += a) - a;
        return a;
    }

    public static int climbStairs3(int n) {
        //Fibonacci
        // base cases
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;

        int one_step_before = 2;
        int two_steps_before = 1;
        int all_ways = 0;

//        int sum = climbStairs3(n-1) + climbStairs3(n-2);
//        return sum;


        for(int i=2; i<n; i++){
            all_ways = one_step_before + two_steps_before;
            two_steps_before = one_step_before;
            one_step_before = all_ways;
        }
        return all_ways;
    }

    public static int climbStairs4(int n){
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;

        return climbStairs4(n-2) + climbStairs4(n-1);
    }



    public static void main (String args[]){
//        System.out.println(climbStairs(30));
//        System.out.println(climbStairs4(30));

        System.out.println(8/10);
    }
}
