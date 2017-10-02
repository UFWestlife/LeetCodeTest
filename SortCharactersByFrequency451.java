import java.util.*;

public class SortCharactersByFrequency451 {
    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) map.put(ch, 1 );
            else map.put(ch, map.get(ch)+1);
            max = Math.max(map.get(ch), max);
        }


        return buildString(build(map, max));
    }

    private static List<Character>[] build(Map<Character, Integer> map, int max){
        List<Character>[] lists = new List[max+1];
        for (Character c :  map.keySet()){
            int count = map.get(c);
            if (lists[count] == null){
                lists[count] = new ArrayList<>();
            }lists[count].add(c);
        }
        return lists;
    }

    private static String buildString(List<Character>[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i > 0; i--) {
            List<Character> list = array[i];
            if (list != null) {
                for (Character c : list) {
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }


    public static void main (String args[]){
        System.out.println(frequencySort("cccnimmma"));
    }
}
