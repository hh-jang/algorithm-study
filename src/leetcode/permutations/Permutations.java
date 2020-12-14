package leetcode.permutations;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        int[] inputs = {1,2,3};
        List<List<Integer>> permute = permute(inputs);
        permute.forEach(System.out::println);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        gridPermute(nums, result, 0, nums.length - 1);

        return result;
    }

    private static void gridPermute(int[] nums, List<List<Integer>> result, int currentLen, int maxSize) {
        if(currentLen == maxSize) {
            List<Integer> partitionOfResult = new ArrayList<>();
            for(int value : nums) {
                partitionOfResult.add(value);
            }
            result.add(partitionOfResult);
            return;
        }

        for(int i = currentLen; i < nums.length; i++) {
            swap(nums, currentLen, i);
            gridPermute(nums, result, currentLen + 1, maxSize);
            swap(nums, currentLen, i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
