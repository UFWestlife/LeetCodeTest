import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum239 {
    public static int[] maxSlidingWindow(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }

    public static void main(String args[]){
        int[] a = {1,3,-1,-3,5,3,6,7};
        int[] res = maxSlidingWindow(a, 3);
        //for (int i : res) System.out.println(i);
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offerFirst(5);

        int tmp = q.peek();
        int tmp1 = q.peekFirst();
        int tmp2 = q.peekLast();

        int tmp3 = q.poll();
        int tmp4 = q.pollFirst();
        int tmp5 = q.pollLast();


    }
}
