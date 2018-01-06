public class FirstBadVersion278 {
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end-start) / 2;
            if (!isBadVersion(mid)) start = mid+1 ;
            else end = mid;
        }
        return start;
    }

    private boolean isBadVersion(int n){
        if (n == 1) return true;
        else return false;
    }

    /**
     * 笔记：经典的BinarySearch，在操作这种二分的时候，变量需要start 和 end，通过调整两个端点
     * 来找中点
     */
}
