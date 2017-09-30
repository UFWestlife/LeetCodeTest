package Queue;

/**
 * Created by Administrator on 21-May-021.
 */
public class Test {
    public static void main(String args[]){
        qqqq q = new qqqq();
//        q.push(1);
//        q.push(2);
//        q.push(3);
//        System.out.println(q.peek());
//        System.out.println(q.poll());
//        q.push(4);
//        System.out.println(q.peek());
//        System.out.println(q.poll());
//        q.push(5);
//        System.out.println(q.poll());
//        System.out.println(q.poll());
//        System.out.println(q.poll());
        int num = 0;
        String s = "ab232";
        for (char c : s.toCharArray()){
            if (Character.isDigit(c))
                num = num * 10 + c-'0';
        }
        System.out.println(num);
        int aa = '6'-'0';


    }
}
