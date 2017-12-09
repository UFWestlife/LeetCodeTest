import java.util.Arrays;

public class WiggleSort280 {
    public static void wiggleSort(int[] nums) {
        for(int i=0;i<nums.length;i++)
            if(i%2==1){
                if(nums[i-1]>nums[i]) swap(nums, i);
            }else if(i!=0 && nums[i-1]<nums[i]) swap(nums, i);
    }
    public static void swap(int[] nums, int i){
        int tmp=nums[i];
        nums[i]=nums[i-1];
        nums[i-1]=tmp;
    }

    public static void main(String args[]){
        int[] a = {3, 5, 2, 1, 6, 4};
        System.out.println(a);
//        System.out.println(1%2);
    }
}
