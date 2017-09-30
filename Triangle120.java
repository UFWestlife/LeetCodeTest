import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 25-Jun-025.
 */
public class Triangle120 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0) return 0;
        int ans = 0;
        for (int i = 0; i < triangle.size(); i++){
            Integer[] tmp = new Integer[triangle.get(i).size()];
            triangle.get(i).toArray(tmp);
            Arrays.sort(tmp);
            ans += tmp[0];
        }
        return ans;
    }
}
