/**
 * Created by Administrator on 23-May-023.
 */
public class HappyNumber202 {
     static int count = 0;
    public static boolean isHappy(int n) {
        int sum = 0;
        while(n != 0){                     //finding sum of square of digits
            sum+=(n%10)*(n%10);
            n/=10;
        }

        count++;
        if(sum == 1){
            return true;
        }
        else if(count < 10000){
            return isHappy(sum);
        }
        else{
            return false;
        }
    }

    public static void main (String args[]){
        System.out.println(isHappy(1221));
    }
}
