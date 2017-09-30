package Queue;
import java.util.*;
/**
 * Created by Administrator on 21-May-021.
 */
class qqqq {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();
    public void push(int x){
        stack1.push(x);
    }

    public int poll(){
        if (stack2.isEmpty()) {
            while (stack1.size() != 0) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }else{
            return stack2.pop();
        }

    }

    public int peek(){
        if (stack2.isEmpty()) {
            while (stack1.size() != 0) {
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }else return stack2.peek();
    }
}
