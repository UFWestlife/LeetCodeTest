/**
 * Created by Administrator on 05-Jun-005.
 */
public class BestTimetoSellStock122 {
    public int maxProfit(int[] A) {
        if(A.length == 0) return 0;
        int min = A[0], max = 0;
        for(int i =1; i < A.length; i++){
            if(A[i] - min < 0) min = A[i];
            else {
                max += A[i] - min;
                min = A[i];
            }
        }
        return max;
    }
}
