import java.util.ArrayList;

/**
 * Created by zunwang on 2017/5/29.
 */
public class ProductofArray238 {
    public static int[] productExceptSelf(int[] nums) {
        int carry = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) carry *= nums[i];
            else arr.add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (arr.contains(i)) nums[i] = 0;
            else nums[i] = carry / nums[i];
        }
        return nums;
    }

    public static int[] productExceptSelf1(int[] nums) {//standard method
        int n = nums.length;
        int[] res = new int[n];
        // Calculate lefts and store in res.
        int left = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0)
                left = left * nums[i - 1];
            res[i] = left;
        }
        // Calculate rights and the product from the end of the array.
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1)
                right = right * nums[i + 1];
            res[i] *= right;
        }
        return res;
    }

    /***
     * For example, given [1,2,3,4], return [24,12,8,6]
     * @param args
     */


    public static void main(String args[]){
        int[] a = {2,0,3,5,1,0,4};
        System.out.println(productExceptSelf(a));
    }
}
