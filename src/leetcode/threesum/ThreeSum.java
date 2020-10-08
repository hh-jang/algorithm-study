package leetcode.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] numbers = {0, 0, 0, 0};
        List<List<Integer>> lists = threeSum(numbers);
        for (List<Integer> list : lists) {
            for (int val : list) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        //[[-1,-1,2],[-1,0,1]]
    }

    // i가 기준점으로 loop를 돌고 j, k의 포인터를 양 끝에서 움직이면서 추적하는 방식으로 구현
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;
        Arrays.sort(nums);

        for (int i = 0, length = nums.length; i < length; i++) {
            // 기준이 되는 nums[i]의 값이 이전에 했던 값이랑 동일하면 할 필요 없다
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int j = i + 1;
            int k = length - 1;

            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> sumZeroList = new ArrayList<>();
                    sumZeroList.add(nums[i]);
                    sumZeroList.add(nums[j]);
                    sumZeroList.add(nums[k]);
                    result.add(sumZeroList);
                    j++;
                    k--;
                    // 중복된 set을 피하기 위해 j, k의 포인터를 값이 달라질때까지 이동
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }
}
