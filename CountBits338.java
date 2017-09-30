/**
 * Created by Administrator on 02-Jun-002.
 */

/*
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation
and return them as an array.

        Example:
        For num = 5 you should return [0,1,1,2,1,2].

        Follow up:

        It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
        Space complexity should be O(n).
        Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
*/
public class CountBits338 {
    public static int[] countBits(int num) {
        int[] result = new int[num+1];
        int a = 0;
        for(int i = 0; i <= num; i++){
            int b = i, count = 0;
            while(b != 0){
                if((b & 1) == 1) count++;
                b = b>>>1;
            }
            result[i] = count;
        }
        return result;
    }

    public static void main(String args[]){
        int[] result = countBits(20);
        for (int i = 0; i < result.length; i = i+2) System.out.print(result[i]+", ");
    }

}
