import java.util.ArrayList;
import java.util.List;

/**
 * Created by zunwang on 2017/6/13.
 */
public class PascalsTriangle118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if (numRows <=0){
            return triangle;
        }
        for (int i=0; i<numRows; i++){
            List<Integer> row =  new ArrayList<>();
            for (int j=0; j<i+1; j++){
                if (j==0 || j==i){
                    row.add(1);
                } else {
                    row.add(triangle.get(i-1).get(j-1)+triangle.get(i-1).get(j));
                }
            }
            triangle.add(row);
        }
        return triangle;
    }

    public static void main(String args[]){
        System.out.println(generate(5));
        System.out.println(Math.sqrt(28));

    }
}
