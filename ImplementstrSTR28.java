public class ImplementstrSTR28 {
    public static int strStr(String haystack, String needle) {
        char[] hay = haystack.toCharArray();
        char[] nee = needle.toCharArray();

        int m = hay.length, n = nee.length;


        for(int i = 0; i < m; i++){
            if(hay[i] == nee[0]){
                if(m - i < n) return -1;
                for(int j = i, k = 0; j < m && k < n; j++, k++){
                    if (hay[j] != nee[k]) return -1;
                }
                return i;
            }
        }

        return -1;
    }

    public static void main(String args[]){
        System.out.println(strStr("hello","ll"));
    }
}
