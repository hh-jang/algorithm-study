package programmers42588;

public class Programmers42588 {
    public static void main(String[] args) {
        int[] heights = {1,5,3,6,7,6,5};

        int[] result = solve(heights);

        for(int i = 0; i < result.length; i++)
            System.out.println(result[i]);
    }

    private static int[] solve(int[] heights) {
        int[] result = new int[heights.length];
        result[0] = 0;

        for(int i = heights.length - 1; i > 0; i--) {
            int receivedIndex = getReceivedTowerIndex(heights, i);
            result[i] = receivedIndex;
        }

        return result;
    }

    private static int getReceivedTowerIndex(int[] heights, int i) {
        for(int j = i - 1; j >= 0; j--) {
            if(heights[j] > heights[i]) return j + 1;
        }

        return 0;
    }
}
