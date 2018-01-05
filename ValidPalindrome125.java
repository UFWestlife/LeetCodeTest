public class ValidPalindrome125 {
    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if ( (65 <= ch && ch <= 90) || (97 <= ch && ch <= 122) || (48 <= ch && ch <= 57)){
                sb.append(String.valueOf(ch).toUpperCase());
            }
        }
        String str = sb.toString();
        System.out.println(str);

        int lo = 0, hi = str.length()-1;
        while(lo <= hi){
            if (str.charAt(lo) != str.charAt(hi))   return false;
            lo++;
            hi--;
        }
        return true;
    }

    public static void main(String args[]){
        System.out.println(isPalindrome("0p"));
    }
}
