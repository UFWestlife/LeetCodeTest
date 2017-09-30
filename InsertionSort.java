/**
 * Created by Administrator on 19-Jun-019.
 */
public class InsertionSort {
    public static void InsertSort(int[] arr)
    {
        int i = 1, j;
        int n = arr.length;
        int target;

        //假定第一个元素被放到了正确的位置上
        //这样，仅需遍历1 - n-1
        for (; i < n; i++)
        {
            j = i;
            target = arr[i];

            while (j > 0 && target < arr[j - 1])
            {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = target;
        }
    }
    public static void main(String args[]){
        int arr[] = {2, 4, 3, 5, 1, 7, 6};
        InsertSort(arr);
        for (int x : arr)
        System.out.println(x);
    }
}
