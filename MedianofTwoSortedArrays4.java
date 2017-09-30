import java.util.Arrays;

/**
 * Created by Administrator on 24-May-024.
 */
public class MedianofTwoSortedArrays4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] nums = new int[m+n];

        System.arraycopy(nums1, 0, nums, 0, m);
        System.arraycopy(nums2, 0, nums, m, n);


        // for(int i = 0; i < m; i++) nums[i] = nums1[i];
        // for(int i = 0; i < n; i++) nums[i+m] = nums2[i];

        Arrays.sort(nums);

        double mid = 0;
        if(nums.length%2 == 0) mid = (double)(nums[(nums.length+1)/2]+nums[(nums.length+1)/2-1])/2;
        else mid =(double) nums[(nums.length+1)/2-1];

        return mid;
    }
    public static void main(String args[]){
        int[] a = {1, 2};
        int[] b = {3, 4};
        System.out.println(findMedianSortedArrays(a, b));

    }
}
