package TwitterOA;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
public class LogSearcher {
    public Collection<String> search(Collection<String> logLines, LocalTime startDate, LocalTime endDate) {
        DateTimeFormatter reform = DateTimeFormatter.ISO_DATE_TIME;//iso_date formatter
        List<String> res = new ArrayList<String>();// store result in a List
        boolean isValid = false;

        for(String str : logLines){//traverse all strings firstly
            //Proccesing input: remove all blanks, tables, enters, etc. using Regular Expression
            String[] cur = str.split("\\s+");
            try{
                LocalTime time = LocalTime.parse(cur[0], reform);
                // transform input log to local time format

                if(time.equals(startDate)|| (time.isBefore(endDate) && time.isAfter(startDate))){
                    //if current time is the starttime or betetweent the start and end, its valid
                    isValid = true;
                    res.add(str);
                }else{
                    isValid = false;
                }
            }
            catch(Exception e){
                if(isValid) res.add(str);
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

        LocalTime startDate = LocalTime.parse(in.nextLine(), formatter);
        LocalTime endDate = LocalTime.parse(in.nextLine(), formatter);

        final int numberOfLogLines = Integer.parseInt(in.nextLine());
        Collection<String> logLines = new ArrayList<String>();
        for (int i = 0; i < numberOfLogLines; i++) {
            logLines.add(in.nextLine());
        }
        in.close();

        Collection<String> res = new LogSearcher().search(logLines, startDate, endDate);
        for (String logLine : res) {
            bw.write(logLine);
            bw.newLine();
        }

        bw.close();
    }
}

