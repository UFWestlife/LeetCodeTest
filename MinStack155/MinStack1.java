package MinStack155;
import java.util.*;
/**
 * Created by Administrator on 19-May-019.
 */
class MinStack1 {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();
    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;

    public void push(int x){
        if (queue2.isEmpty() || !queue1.isEmpty()){
            queue1.add(x);
        } else if (queue1.isEmpty() || !queue2.isEmpty()){
            queue2.add(x);
        } else if (queue1.isEmpty() || queue2.isEmpty()){
            queue1.add(x);
        }
        if (x < min) min = x;
        stack.push(min);

    }

    public int pop(){
        int pop = 0;
        if (!queue1.isEmpty()){
            while(queue1.size() != 1){
                int tmp = queue1.poll();
                queue2.add(tmp);
            }
            pop = queue1.poll();

        }else if (!queue2.isEmpty()){
            while(queue2.size() != 1){
                int tmp = queue2.poll();
                queue1.add(tmp);
            }
            pop = queue2.poll();
        }else pop = queue1.remove();
        stack.pop();
        return pop;
    }

    public int top(){
        int top = 0;
        if (!queue1.isEmpty()){
            while(queue1.size() != 1){
                int tmp = queue1.poll();
                queue2.add(tmp);
            }
            top = queue1.poll();
            queue2.add(top);
        }else if (!queue2.isEmpty()){
            while(queue2.size() != 1){
                int tmp = queue2.poll();
                queue1.add(tmp);
            }
            top = queue2.poll();
            queue1.add(top);
        }else return 0;
        return top;
    }

    public int getMin(){
        int min = 0;
        min = stack.peek();
        return min;
    }

    public boolean empty(){
        if(queue1.isEmpty() || queue2.isEmpty()) return true;
        else return false;
    }

}
