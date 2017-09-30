/**
 * Created by Administrator on 26-May-026.
 */
public class PalindromeNumber9 {
    public static boolean isPalindrome(int x) {
        //negative number
        if(x < 0)
            return false;

        int len = 1;
        while(x / len >= 10)
            len *= 10;

        while(x > 0)    {

            //get the head and tail number
            int left = x / len;
            int right = x % 10;

            if(left != right)
                return false;
            else    {
                //remove the head and tail number
                x = (x % len) / 10;
                len /= 100;
            }
        }
        return true;
    }
    public static void main (String args[]){
        int x = 313;

        System.out.println(isPalindrome(x));
    }
}
