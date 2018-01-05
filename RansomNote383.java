public class RansomNote383 {
    public static boolean canConstruct(String a, String b) {
        if(b.length() < a.length() || a.length() == 0 || b.length() == 0) return false;
        if(b.length() == a.length()){
            if(a == b) return true;
            else return false;
        }

        boolean mark = true;
        for(int i = 0; i < b.length(); i++){
            if(b.charAt(i) == a.charAt(0)){
                for(int j = i, count = 0; j < b.length() && count < a.length(); j++, count++){
                    if(b.charAt(j) != a.charAt(count)){
                        mark = false;
                        i = j;
                        break;
                    }
                }
            }

            if(mark == false) continue;
            else return mark;
    }
        return mark;
    }

    public static void main(String args[]){
        System.out.println(canConstruct("aa", "aab"));
    }
}
