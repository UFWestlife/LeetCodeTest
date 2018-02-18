package TwitterOA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InformationMasking {
    private static String emailMask(String email){
        //[0, 9] = [48, 57], [A, Z] = [65, 90], [a, z] = [97, 122]
        int mark = email.indexOf("@");
        StringBuilder sb = new StringBuilder();
        sb.append(email.charAt(0));
        sb.append("*****");
        sb.append(email.charAt(mark-1));
        sb.append(email.substring(mark, email.length()));
        return sb.toString();
    }


    private static String phoneMask(String phone){
        phone = phone.replace(" ", "");
        StringBuilder sb = new StringBuilder();
        if (phone.charAt(0) == '+'){
            sb.append("+");
            int count = 0;
            for (int i = 0; i < phone.length(); i++){
                if (phone.charAt(i) == '(') count = i-1;
            }
            while(count > 0){
                sb.append("*");
                count--;
            }
            sb.append("_***_***_");
            sb.append(phone.substring(phone.length()-4, phone.length()));

        }else{
            sb.append("***_***_");
            sb.append(phone.substring(phone.length()-4, phone.length()));
        }


        return sb.toString();
    }

    public static void main(String args[] ) throws Exception{  /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        System.out.println(emailMask("neuzun93@gmail.com"));
        System.out.println(phoneMask("(333) 444 - 5667"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input;
//        while((input = br.readLine()) != null){
//            //String input = br.readLine();
//            String[] inputs = input.trim().split(":");
//            if(inputs[0].trim().equals("E")){
//                System.out.println(emailMask(inputs[1].trim()));
//            }else if(inputs[0].trim().equals("P")){
//                System.out.println(phoneMask(inputs[1].trim()));
//            }
//        }
//        br.close();
    }
}
