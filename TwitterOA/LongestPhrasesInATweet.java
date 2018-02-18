package TwitterOA;

import java.util.LinkedList;
import java.util.Queue;

public class LongestPhrasesInATweet {
    static int maxLength(int[] a, int k) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int sum = 0, max = 0, curLen = 0;//set parameters
        for(int i : a){//traverse all words
            if(i + sum > k){ // if total length exceeds the limit
                while( i+ sum > k){
                    max = Math.max(queue.size(), max);//get max number of words
                    if(!queue.isEmpty())
                        curLen = queue.poll();
                    sum -= curLen;
                }//until satisfying k
                sum += i;
                queue.offer(i);
                max = Math.max(max, queue.size());
            }else{
                queue.offer(i);
                sum += i;
            }
        }
        return Math.max(max, queue.size());

    }
}
