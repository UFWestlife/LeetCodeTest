import java.util.HashSet;
//find maxmum two integers in an array who has maximum XOR value
public class FindMaxXOR421 {
    public static int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            HashSet<Integer> set = new HashSet<Integer>();
            for (int num : nums) {
                set.add(num & mask); // reserve Left bits and ignore Right bits
            }

            /* Use 0 to keep the bit, 1 to find XOR
             * 0 ^ 0 = 0
             * 0 ^ 1 = 1
             * 1 ^ 0 = 1
             * 1 ^ 1 = 0
             */
            int tmp = max | (1 << i); // in each iteration, there are pair(s) whoes Left bits can XOR to max
            for (int prefix : set) {
                if (set.contains(tmp ^ prefix)) {
                    max = tmp;
                }
            }
        }
        return max;
    }

    public static void main(String args[]){
        int[] a = {3, 10, 5, 25, 2, 8};
//        System.out.println(findMaximumXOR(a));
        int test = Integer.parseInt("1", 2)<<31|0;
        String bit = Integer.toBinaryString(test);
        System.out.println("int = "+test+"; "+"bit = "+bit+";");
    }
}
