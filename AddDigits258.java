/**
 * Created by Administrator on 26-May-026.
 */
public class AddDigits258 {
//    static int sum = 0;
    public static int addDigits(int num) {
        int sum = 0,  digts = 0, nums = num;
        if (num >= 10){
            while(nums != 0){
                nums /= 10;
                digts++;

            }
            if (sum >= 10 || sum == 0){
                for (int i = 0; i < digts; i++){
                    sum += num%10;
                    num /= 10;
                }
            }
            int cnm = addDigits(sum);
            return cnm;
        }else return num;


    }

    public static int addDigits1(int num) {
        if (num == 0){
            return 0;
        }
        if (num % 9 == 0){
            return 9;
        }
        else {
            return num % 9;
        }
    }

    public static void main (String args[]){
        System.out.println(addDigits(38));
    }
}
