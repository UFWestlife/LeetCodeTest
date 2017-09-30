/**
 * Created by Administrator on 08-Jun-008.
 */
public class RemoveElement27 {
    public static int removeElement(int[] nums, int val) {
        int count = 0;
        for(int num : nums){
            if(num == val) count++;
        }
        return nums.length-count;
    }
    public static void main (String args[]){
        int[] x ={3,2,2,3};

        System.out.println(removeElement(x,3));
    }
}
