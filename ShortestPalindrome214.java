public class ShortestPalindrome214 {
    public static String shortestPalindrome(String s) {
        char[] ch = s.toCharArray();
        if(ch.length == 1) return s;
        if(ch.length == 2) return String.valueOf(ch[1])+s;

        String str = "";
        for(int i = ch.length-2; i > 0; i--){
            if(ch[i-1] == ch[i+1]){
                str = s.substring(i+1);
            }
        }

        if(str != ""){
            str = s.substring(1);
        }

        return str;
    }


    public static void main(String args[]){
        System.out.println(shortestPalindrome("aacecaaa"));
    }
}
