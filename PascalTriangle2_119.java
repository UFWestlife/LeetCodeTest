import java.util.ArrayList;
import java.util.List;
// given a row number, return the numbers of the row.
//eg. row = 3, return [1, 3, 3, 1]
public class PascalTriangle2_119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0;i<rowIndex+1;i++) {
            res.add(1);
            for(int j=i-1;j>0;j--) {
                res.set(j, res.get(j-1)+res.get(j));
            }
        }
        return res;
    }
}
