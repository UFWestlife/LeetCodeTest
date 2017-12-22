public class SearchInRotatedSortedArray33 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n-1;
        int index;


        while(start < end){
            int mid = (start+end)/2;
            if(nums[mid] > nums[end]) start = mid+1;
            else end = mid;
        }

        index = end;
        start = 0; end = n-1;

        while(start <= end){
            int mid = (start+end)/2;
            int realMid = (mid+index)%n;
            if(nums[realMid] == target) return realMid;
            if(nums[realMid] < target) start = mid+1;
            else end = mid-1;
        }
        return -1;
    }
}
