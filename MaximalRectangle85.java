import java.util.Stack;

public class MaximalRectangle85 {
    public static int maximalRectangle(int[][] matrix) {
        int m = matrix.length; //行的数目
        int n = m == 0 ? 0 : matrix[0].length;// 列的数目

        int[][] height = new int[m][n + 1];
        int maxArea = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0) height[i][j] = 0;
                else height[i][j] = i == 0 ? 1 : height[i - 1][j] + 1;
            }
        }

        for (int i = 0; i < m; i++) {
            int area = maxAreaInHist(height[i]);
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;

    }

     static int maxAreaInHist(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int max = 0;

        while (i < height.length) {
            if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
                stack.push(i++);
            } else {
                int t = stack.pop();
                int tmpArea;
                if (stack.isEmpty()) tmpArea = height[t] * i;
                else tmpArea = height[t] * (i - stack.peek() - 1);
                max = Math.max(max, tmpArea);
            }
        }
        return max;
    }

    public static void main(String args[]){
        int [][]a={
                {1, 0 ,1, 0, 0},
                {1, 0 ,1, 1, 1},
                {1, 1 ,1, 1, 1},
                {1, 0 ,0, 1, 0}
        };
        System.out.println(maximalRectangle(a));
    }
}
