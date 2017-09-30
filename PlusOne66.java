/**
 * Created by Administrator on 25-May-025.
 */
public class PlusOne66 {
    public static int[] plusOne(int[] digits) {
        int[] cao = new int[1];
        if(digits.length == 1 && digits[0] == 0){
            cao[0] = 1;
            return cao;
        }
        String[] sstr = new String[digits.length];
        for(int i=0; i<digits.length; i++){
            sstr[i] = String.valueOf(digits[i]);
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < sstr.length; i++){
            sb. append(sstr[i]);
        }
        String s = sb.toString();

        int a = Integer.parseInt(s, 2);

        a++;
        String str = Integer.toBinaryString(a);
        int[] intArray = new int[str.length()];// 新建一个数组用来保存num每一位的数字
        for (int i = 0; i < str.length(); i++) {
            // 遍历str将每一位数字添加如intArray
            Character ch = str.charAt(i);
            intArray[i] = Integer.parseInt(ch.toString());
        }
        return intArray;

//        int n = digits.length;
//        for(int i=n-1; i>=0; i--) {
//            if(digits[i] < 9) {
//                digits[i]++;
//                return digits;
//            }
//
//            digits[i] = 0;
//        }
//
//        int[] newNumber = new int [n+1];
//        newNumber[0] = 1;
//
//        return newNumber;
    }
    public static void main(String args[]){
        int[] digits = {1,1,0};
        System.out.println(plusOne(digits));
    }
}
