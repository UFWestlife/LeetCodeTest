import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class hhmm {
    public static String solution(String S) {
        // write your code in Java SE 8

        String[] val = S.split(":");
        HashSet<Integer> set = new HashSet<>();

        //Transfer String time to Int time array

        String sInput = val[0]+val[1];//"2359"
        String permuRes = "";

        List<List<String>> list = new ArrayList<>();
        boolean[] used = new boolean[4];
        backPerm(list, new ArrayList<>(), sInput, used);

        HashSet<String> setPermu = new HashSet<>();
        for (List<String> tmp : list){
            String str = "";
            for (String strr : tmp){
                str += strr;
            }
            setPermu.add(str);
        }

        ArrayList<String> setRes = new ArrayList<>();
        for(String s : setPermu){
            String hour = s.substring(0, 2);
            String minu = s.substring(2);
            if(hour.charAt(0) == '0'){
                hour = hour.substring(1,2);
            }
            if(minu.charAt(0) == '0'){
                minu = minu.substring(1,2);
            }
            if(Integer.parseInt(hour) >= 0 && Integer.parseInt(hour) < 24){
                if(Integer.parseInt(minu) >= 0 && Integer.parseInt(minu) < 60){
                    setRes.add(s);
                }
            }
        }
        String clt = new String();

        if(setRes.size() == 1){
            return setRes.get(0).substring(0,2) + ":" + setRes.get(0).substring(2);
        } else {
            int oriMin = Integer.parseInt(sInput.substring(0,2))*60+
                    Integer.parseInt(sInput.substring(2));
            int minDiff = Integer.MAX_VALUE;
            for(String s : setRes){
                int totalMin = Integer.parseInt(s.substring(0,2))*60+
                        Integer.parseInt(s.substring(2));
                int diff = 0;
                if(totalMin > oriMin){
                    diff = totalMin - oriMin;
                }else{
                    diff = totalMin - oriMin + 24*60;
                }

                if(diff < minDiff){
                    minDiff = diff;
                    clt = s;
                }


            }
        }

        String result = clt.substring(0,2) + ":" + clt.substring(2);
        return result;
    }

    //Permutation with duplicate strings, requires a sorted input!!!!
    public static void backPerm(List<List<String>> list, List<String> tempList, String str, boolean[] used){
        if (tempList.size() == str.length()){
            list.add(new ArrayList<>(tempList));
        }else {
            for (int i = 0; i < str.length(); i++){
//                if(tempList.contains(String.valueOf(str.charAt(i)))) continue;
                if (used[i] || i > 0 && str.charAt(i) == str.charAt(i-1) && !used[i-1]) continue;
                used[i] = true;
                tempList.add(String.valueOf(str.charAt(i)));
                backPerm(list, tempList, str, used);
                used[i] = false;
                tempList.remove(tempList.size()-1);
            }
        }
    }

    public static void main(String args[]){
        System.out.println(solution("12:00"));

        List<List<String>> list = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        boolean[] used = new boolean[4];
        backPerm(list, tempList, "1", used);
        System.out.println(list);


    }
}
