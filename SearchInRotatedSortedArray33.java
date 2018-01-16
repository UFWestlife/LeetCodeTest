public class SearchInRotatedSortedArray33 {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return nums[0] == target ? 0 : -1;
        int peak = findPeakPoint(nums);
        if(peak == -1) return binarySearch(nums, 0, nums.length-1, target);
        int left = binarySearch(nums, 0, peak, target);
        int right = binarySearch(nums, peak+1, nums.length-1, target);
        if(left == -1 && right == -1) return -1;
        return left == -1 ? right : left;
    }

    private int findPeakPoint(int[] nums){
        int start = 0, end = nums.length - 1;
        while(start + 1 < end){
            int mid = (end - start) / 2 + start;
            if(nums[mid] >= nums[0]){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(nums[end] > nums[start]) return -1;
        else return start;
    }

    private int binarySearch(int[] nums, int start, int end, int target){
        while(start + 1 < end){
            int mid = (end - start) / 2 + start;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(nums[start] == target) return start;
        if(nums[end] == target) return end;
        return -1;
    }
}
