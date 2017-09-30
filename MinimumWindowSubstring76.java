public class MinimumWindowSubstring76 {
    static int initTargetHash(int []targethash, String Target) {
        int targetnum =0 ;
        for (char ch : Target.toCharArray()) {
            targetnum++;
            targethash[ch]++;
        }
        return targetnum; //统计目标字符个数，并在targethash中把对应的ASCII码置为1；
    }
    static boolean valid(int []sourcehash, int []targethash) {

        for(int i = 0; i < 256; i++) {
            if(targethash[i] > sourcehash[i])// 如果
                return false;
        }
        return true;
    }


    public static String minWindow(String Source, String Target) {
        int ans = Integer.MAX_VALUE;
        String minStr = "";

        int[] sourcehash = new int[256];
        int[] targethash = new int[256];

        initTargetHash(targethash, Target);
        int j = 0, i = 0;
        for(i = 0; i < Source.length(); i++) {
            while( !valid(sourcehash, targethash) && j < Source.length()  ) {
                sourcehash[Source.charAt(j)]++;
                if(j < Source.length() )
                    j++;
                else
                    break;
            }
            if(valid(sourcehash, targethash) ){
                if(ans > j - i ) {
                    ans = Math.min(ans, j - i );
                    minStr = Source.substring(i, j );
                }
            }
            sourcehash[Source.charAt(i)]--;
        }
        return minStr;
    }

    public static void main (String args[]){
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));

        System.out.println((char)97);
    }
}
