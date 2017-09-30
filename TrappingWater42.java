/**
 * Created by Administrator on 03-Jun-003.
 */
public class TrappingWater42 {
    public static int trap(int[] A) {
        if (A.length < 3) return 0;

        int ans = 0;
        int l = 0, r = A.length - 1;

        // find the left and right edge which can hold water
        while (l < r && A[l] <= A[l + 1]) l++;
        while (l < r && A[r] <= A[r - 1]) r--;

        while (l < r) {
            int left = A[l];
            int right = A[r];
            if (left <= right) {
                // add volum until an edge larger than the left edge
                while (l < r && left >= A[++l]) {
                    ans += left - A[l];
                }
            } else {
                // add volum until an edge larger than the right volum
                while (l < r && A[--r] <= right) {
                    ans += right - A[r];
                }
            }
        }
        return ans;
    }

    public static int trap1(int[] A) {
        if(A==null || A.length==0) return 0;
        int leftmax = 0;
        int rightmax = 0;
        int left = 0;
        int right = A.length-1;
        int max = 0;
        while(left<right) {
            leftmax = Math.max(leftmax, A[left]);
            rightmax = Math.max(rightmax, A[right]);
            if(leftmax < rightmax) {
                max += leftmax -A[left];
                left++;
            }else {
                max += rightmax - A[right];
                right--;
            }
        }
        return max;
    }

    public static void main(String args[]){
        int[] a = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap1(a));
    }
}
