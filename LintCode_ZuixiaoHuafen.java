import java.util.Arrays;

public class LintCode_ZuixiaoHuafen {
    public static int findMin(int[] arr) {
        // write your code here
        Arrays.sort(arr);
        int halfSum = sum(arr, 0, arr.length-1)/2;
        int tmp = 0, cur =0;

        for(int i = 0; i < arr.length; i++){
            tmp += arr[i];
            if(tmp >= halfSum){
                cur = i-1;
            }
        }

        return Math.abs(sum(arr, 0, cur) - sum(arr, cur+1, arr.length-1));


    }


    public static int sum(int[] arr, int start, int end){
        int sum = 0;
        for(int i = start; i <= end; i++){
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String args[]){
        int[] arr = {1, 5, 6, 11};
        System.out.print(findMin(arr));

    }
}
