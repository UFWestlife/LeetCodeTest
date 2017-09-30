import java.util.*;

/**
 * Created by zunwang on 2017/6/10.
 */
public class phoneNumber {
    static Map<Character, String> map = new HashMap<>();
    static List<String> list = new LinkedList<>();



    public static List<String> PhoneNumber(String str){



        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < str.length(); i=i+2){
            for (int j = 0; j < map.get(str.charAt(i)).length(); j++){// Control the index of 1st Strings on pad
                if (i == 0) {
                    buffer.append(map.get(str.charAt(i)).charAt(j));
                    for (int k = 0; k < map.get(str.charAt(i+1)).length(); k++){//Control the index of 2nd String
                        buffer.append(map.get(str.charAt(i+1)).charAt(k));
                        list.add(buffer.toString());
                        buffer.deleteCharAt(buffer.toString().length()-1);
                    }
                    buffer.setLength(0);
                }
                else {
                    for (int count = 0; count < list.size(); count++){
                        String ss = list.get(count);
                        buffer.append(ss);
                        buffer.append(map.get(str.charAt(i)).charAt(j));
                        list.set(count, buffer.toString());
                        buffer.setLength(0);
                    }
                }

            }
        }


        return list;
    }
   public static void main (String args[]){
//        System.out.println(PhoneNumber("234"));
//       int[] a = {1, 2, 3, 4};
//       int[] b = a;
//       int[] c = a.clone();

       int[] res = {1,2,3};
       double fz = (double)(res[res.length/2]+res[res.length/2-1])/2;
       double ff = (double) res[res.length/2];
       System.out.println(ff+", ");

   }


}
