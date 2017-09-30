package MedianFinder;
import MedianFinder.MedianFinder;

import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by zunwang on 2017/7/18.
 */
public class Test {
    public static void main(String args[]){
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        System.out.print(obj.findMedian());
        obj.addNum(3);
        System.out.print(obj.findMedian());

        Queue<Integer> q = new PriorityQueue<>();
        q.offer(1);
        q.offer(1);
        q.offer(2);
        q.offer(4);
        q.offer(5);

        System.out.println(q);
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
    }

}
