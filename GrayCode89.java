import java.util.LinkedList;
import java.util.List;

public class GrayCode89 {
    public static List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1<<n; i++) {
            result.add(i ^ i >> 1);
        }
        return result;
    }

    public static void main(String args[]){
        System.out.println(grayCode(2));
        int a = 1;
        System.out.println(1>>2);
    }
}
