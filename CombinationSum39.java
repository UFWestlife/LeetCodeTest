import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//Distinguish this from Permutation backtracking problems
public class CombinationSum39 {
    public static List<List<Integer>> combinationSum(int[] A, int target) {
        Arrays.sort(A);
        List<List<Integer>> list = new ArrayList<>();
        permu(list, new ArrayList<>(), A, target, 0);
        return list;

    }

    private static void permu( List<List<Integer>> list, List<Integer> templist, int[] A, int remain, int start){
        if(remain < 0) return;
        if(remain == 0){
            list.add(new ArrayList<>(templist));
        }else{
            for(int i = start; i < A.length; i++){
                templist.add(A[i]);
                permu(list, templist, A, remain-A[i], i);// not i+1 because we can reuse same element
                templist.remove(templist.size()-1);
            }
        }
    }



    private void permuNotReuse( List<List<Integer>> list, List<Integer> templist, int[] A, int remain, int start){
        if(remain < 0) return;
        if(remain == 0){
            list.add(new ArrayList<>(templist));
        }else{
            for(int i = start; i < A.length; i++){
                if(i > start && A[i] == A[i-1] )continue;// skip duplicate
                templist.add(A[i]);
                permu(list, templist, A, remain-A[i], i+1);
                templist.remove(templist.size()-1);
            }
        }
    }

    public static void main(String args[]){
        int[] A = {2,2,3};
        combinationSum(A, 4);
    }
}
