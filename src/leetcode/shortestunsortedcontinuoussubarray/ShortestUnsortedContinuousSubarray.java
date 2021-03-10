package leetcode.shortestunsortedcontinuoussubarray;

public class ShortestUnsortedContinuousSubarray {

    public static void main(String[] args) {
        int[] input = {2,6,4,8,10,9,15};
//        int[] input = {1};
        int result = findUnsortedSubarray(input);
        System.out.println(result);
    }

    // 왼 -> 오, 오 -> 왼으로 총 2번 탐색
    // 왼 -> 오 도중 최대값 갱신하면서 낮아지는 구간 중 가장 큰 index를 구함
    // 오 -> 왼 도중 최소값 갱신하면서 높아지는 구간 중 가장 작은 index를 구함
    // 두 지점의 차이로 구함
    // 그래프 그려보니까 할만한듯?
    public static int findUnsortedSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int left = - 1;
        int right = - 1;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max) max = nums[i];
            if(nums[i] < max) right = i;
        }

        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] < min) min = nums[i];
            if(nums[i] > min) left = i;
        }

        if(left == -1 && right == -1) return 0;

        return right - left + 1;
    }
}
