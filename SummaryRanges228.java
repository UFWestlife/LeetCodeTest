import java.util.ArrayList;
import java.util.List;

public class SummaryRanges228 {
    public static List<String> summaryRanges(int[] nums) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();

        if (nums.length == 0) return list;
        if (nums.length == 1){
            list.add(String.valueOf(nums[0]));
            return list;
        }

        for (int i = 0; i < nums.length; i++){
            int tmp = nums[i];
            boolean consecutive = false;
            if (i == nums.length - 1) list.add(String.valueOf(nums[nums.length-1]));
            for (int j = i+1; j < nums.length; j++){
                if (nums[j] != tmp+1 && consecutive == false){
                    sb.append(String.valueOf(nums[i]));
                    list.add(sb.toString());
                    sb.setLength(0);
                    break;
                }

                if (nums[j] == tmp+1 && j < nums.length-1){
                    consecutive = true;
                    tmp++;
                }else if (nums[j] == tmp+1 && j == nums.length-1){
                    sb.append(String.valueOf(nums[i])+"->"+String.valueOf(nums[j]));
                    i = j;
                    list.add(sb.toString());
                    sb.setLength(0);
                    break;
                }else if (nums[j] > tmp+1){
                    sb.append(String.valueOf(nums[i])+"->"+String.valueOf(tmp));
                    i = j-1;
                    list.add(sb.toString());
                    sb.setLength(0);
                    break;
                }
            }
        }
        return list;
    }

    public static List<String> summaryRanges1(int[] nums) {
        List<String> list=new ArrayList();
        if(nums.length==1){
            list.add(nums[0]+"");
            return list;
        }
        for(int i=0;i<nums.length;i++){
            int a=nums[i];
            while(i+1<nums.length&&(nums[i+1]-nums[i])==1){
                i++;
            }
            if(a!=nums[i]){
                list.add(a+"->"+nums[i]);
            }else{
                list.add(a+"");
            }
        }
        return list;
    }

    public static void main (String args[]){
        int[] a = {0,1,2,4,5,7};
        System.out.print(summaryRanges(a).toString());
    }
}
