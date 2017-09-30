import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAnagrams49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        Arrays.sort(strs);

//        for(String str : strs){
//            char[] ch = str.toCharArray();
//
//        }
        return res;
    }

    public static void main(String args[]){
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}
