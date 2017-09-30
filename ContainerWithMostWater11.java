/**
 * Created by Administrator on 26-May-026.
 */
public class ContainerWithMostWater11 {
    public static int maxArea(int[] height) {
        int l = height.length;
        int area = 0;
        for(int i = 0; i < l-1; i++){
            for(int j = i+1; j < l; j++){
                int tmp = 0;
                if(height[i] == 0 || height[j] == 0) tmp = 0;
                else tmp = Math.min(height[i],height[j])*Math.abs(i-j);
                area = Math.max(area, tmp);
            }
        }
        return area;
    }

    public static void main (String args[]){
        int[] height = {1,2,4,3};

        System.out.println(maxArea(height));
    }
}
