import java.util.Arrays;

public class BulbSwitcher319 {
    public static int bulbSwitch(int n) {
        int[] bulb = new int[n+1];
        Arrays.fill(bulb, 1);
        bulb[0] =  -1;
        if (n == 1) return n;

        for (int i = 2; i < n+1; i++){
            if (i % 2 == 0){
                for (int j = i; j < n+1; j = j + i){
                    if (bulb[j] == 1) bulb[j] = 0;
                    else bulb[j] = 1;
                }
            }else{
                for (int j = i; j < n+1; j = j + i){
                    if (bulb[j] == 1) bulb[j] = 0;
                    else bulb[j] = 1;
                }
            }
        }
        int count = 0;
        for (int i : bulb){
            if (i == 1) count++;
        }

        return count;
    }

    public static void main(String args[]){
        System.out.print(bulbSwitch(3));
//        System.out.print("1");
    }
}
