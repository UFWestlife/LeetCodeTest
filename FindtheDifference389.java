public class FindtheDifference389 {
    public static char findTheDifference(String s, String t) {
        int[] sh = new int[256];
        int[] th = new int[256];

        for (char ch : t.toCharArray()) {
            // targetnum++;
            th[ch]++;
        }

        for (char ch : s.toCharArray()) {
            // targetnum++;
            sh[ch]++;
        }
        int res = 0;
        for(int i = 0; i < 256; i++){
            if(th[i] > sh[i]  ) res = i;
        }

        return (char)res;
    }
    public static void main (String args[]){
        System.out.println(findTheDifference("abcd","cdeba"));
    }
}
