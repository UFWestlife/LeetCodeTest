package TwitterOA;
/*
Time series aggregation的代码，只能过第一个test case,感觉自己代码逻辑没问题，应该是某处小bug,傻逼hac ...

Map logs的key是月份，如果有相同的月份就不行。
lz，我知道Bug是什么了，跟endMonth相同的date也要丢掉

Time series aggregation那道题楼主代码基本没毛病， 但是他测试时候比较时间区间是包括开始的月份，不算结束的月份（左闭右开），
所以都用Date.before()比较会出问题，加上这个限制应该就可以通过测试了
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class TimeSeriesAggregation {
    static String beginMonth;
    static String endMonth;
    // static Map<String, Map<String, Integer>> logs = new TreeMap<>(Collections.reverseOrder());
    static Map<String, Map<String, Integer>> logs = new HashMap<>();
    static PriorityQueue<Log> maxHeap;

    static class LogComparator implements Comparator<Log>{
        public int compare(Log log1, Log log2){
            String date1 = log1.date;
            String date2 = log2.date;
            String category1= log1.category;
            String category2 = log2.category;
            if(date1.equals(date2)){
                return category1.compareTo(category2);
            }else{
                return date2.compareTo(date1);
            }
        }
    }

    static class Log{
        String date;
        String category;
        int cnt;
        Log(String date, String category, int cnt){
            this.date = date;
            this.category = category;
            this.cnt = cnt;
        }
    }

    static String removeDD(String date){
        //return date;
        Date initDate = null;
        try{
            initDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        }catch (ParseException e){
            e.printStackTrace();
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
        String parsedDate = formatter.format(initDate);
        return parsedDate;

    }

    static boolean isBefore(String d1, String d2){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        Date date1 = null;
        Date date2 = null;
        try{
            date1 = format.parse(d1);
            date2 = format.parse(d2);
        }catch(ParseException e){
            e.printStackTrace();
        }
        return date1.before(date2);
    }

    public static void main(String args[] ) throws Exception {//[br]        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        String line = null;
        int num = 0;
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while((line = br.readLine()) != null){
                if(num == 0){
                    String[] interval = line.trim().split(",");/*[br]*/                    if(interval.length != 2){
                        throw new Exception("invalid input!");
                    }
                    beginMonth = interval[0].trim();
                    endMonth = interval[1].trim();
                    //System.out.println(line);
                    num++;
                }else if(num == 1){
                    num++;
                    continue;

                }else{
                    //System.out.println(line);
                    String[] lines = line.trim().split(",");/*[br]*/                     if(lines.length != 3){
                        throw new Exception("invalid input!");
                    }
                    String date = lines[0].trim();
                    //System.out.println(date);
                    String trans_date = removeDD(date);
                    //System.out.println(trans_date);
                    String category = lines[1].trim();
                    String count = lines[2].trim();
                    int cnt = Integer.parseInt(count);
                    //System.out.println(date);
                    if(isBefore(trans_date, beginMonth) || isBefore(endMonth, trans_date) || cnt == 0) continue;
                    if(!logs.containsKey(trans_date)){
                        logs.put(trans_date, new HashMap<String, Integer>());
                    }
                    Map<String, Integer> map = logs.get(trans_date);
                    if(!map.containsKey(category)){
                        map.put(category, cnt);
                    }else{
                        map.put(category, map.get(category) + cnt);
                    }

                    logs.put(trans_date,map);
                    num++;
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        maxHeap = new PriorityQueue<Log>(num, new LogComparator());

        for(Map.Entry<String, Map<String, Integer>> entry : logs.entrySet()){

            String date = entry.getKey();
            //System.out.println(date);
            Map<String, Integer> map = entry.getValue();

            for(Map.Entry<String, Integer> sub_entry : map.entrySet()){
                String category = sub_entry.getKey();
                int cnt= sub_entry.getValue();
                maxHeap.offer(new Log(date, category, cnt));
                //System.out.println(date + " "  + category +  " " + cnt);
            }
        }

        Log prev = null;
        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty()){
            Log cur = maxHeap.poll();
            if(prev == null){
                sb.append(cur.date);
                sb.append(',');
                sb.append(' ');
                sb.append(cur.category);
                sb.append(',');
                sb.append(' ');
                sb.append(cur.cnt);
            }else if(prev.date.equals(cur.date)){
                sb.append(',');
                sb.append(' ');
                sb.append(cur.category);
                sb.append(',');
                sb.append(' ');
                sb.append(cur.cnt);
            }else{
                String printString = sb.toString();
                System.out.println(printString);
                sb = new StringBuilder();
                sb.append(cur.date);
                sb.append(',');
                sb.append(' ');
                sb.append(cur.category);
                sb.append(',');
                sb.append(' ');
                sb.append(cur.cnt);
            }
            prev = cur;
        }
        String printString = sb.toString();
        System.out.println(printString);
      /*
        for(Map.Entry<String, Map<String, Integer>> entry : logs.entrySet()){
            StringBuilder sb = new StringBuilder();
            String date = entry.getKey();
            sb.append(date);
            Map<String, Integer> map = entry.getValue();

            for(Map.Entry<String, Integer> sub_entry : map.entrySet()){
              String category = sub_entry.getKey();
              int cnt= sub_entry.getValue();
              sb.append(',');
              sb.append(' ');
              sb.append(category);
              sb.append(',');
              sb.append(' ');
              sb.append(cnt);
            }
            System.out.println(sb.toString());
        }
    */
    }
}
