package leetcode.containerwithmostwater;

public class ContainerWithMostWater {
    public static void main(String[] args) {
//        int[] input = {1,8,6,2,5,4,8,3,7};
        int[] input = {1,2,1};
        System.out.println(maxArea(input));
    }

    public static int maxArea(int[] height) {
        int length = height.length;
        int start = 0;
        int end = length - 1;
        int result = Integer.MIN_VALUE;
        int currentArea;
        int standardVertical;

        while (end - start > 0) {
            standardVertical = height[start] > height[end] ? height[end] : height[start];
            currentArea = (end - start) * standardVertical;

            if(height[start] > height[end]) end--;
            else start++;

            result = Math.max(currentArea, result);
        }

        return result;
    }
}
