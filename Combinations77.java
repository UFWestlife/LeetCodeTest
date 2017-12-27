import java.util.ArrayList;
import java.util.List;

public class Combinations77 {
    static int count = 0;
    public static List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = i+1;
        }
        List<List<Integer>> list = new ArrayList<>();
        search(list, nums, new ArrayList<>(), 0, k);
        return list;
    }

    private static void search(List<List<Integer>> list, int[] nums, List<Integer> temp, int m, int n){
        if(count == n){
            list.add(new ArrayList<>(temp));
        }else{
            for (int i = m; i < nums.length; i++){
                count++;
                temp.add(nums[i]);
                search(list, nums, temp, i+1, n);
                temp.remove(temp.size()-1);
                count--;
            }
        }
    }

    public static void main(String args[]){

        System.out.println(combine(4, 2));
    }
}
