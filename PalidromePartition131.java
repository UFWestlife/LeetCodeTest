import java.util.ArrayList;
import java.util.List;

        /*Given a string s, partition s such that every substring of the partition is a palindrome.
        Return all possible palindrome partitioning of s.

        For example, given s = "aab",
        Return
        [
            ["aa","b"],
            ["a","a","b"]
        ]
        */


public class PalidromePartition131 {
    public static List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        backPerm(list, new ArrayList<>(), s, 0);
        return list;
    }

    private static void backPerm(List<List<String>> list, List<String> tempList, String str, int start) {
        if (start == str.length()) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < str.length(); i++) {
                if (isP(str, start, i)) {
                    tempList.add(str.substring(start, i + 1));
                    backPerm(list, tempList, str, i + 1);
                    tempList.remove(tempList.size() - 1);
                }


            }
        }
    }

    private static boolean isP(String s, int lo, int hi) {
        while (lo < hi) {
            if (s.charAt(lo++) != s.charAt(hi--)) return false;
        }
        return true;
    }

    public static void main(String args[]){
        System.out.println(partition("aab"));
    }
}
