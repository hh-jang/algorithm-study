package leetcode.findallduplicatesinanarray;

import java.util.*;

public class FindAllDuplicatesInAnArray {

    public static void main(String[] args) {
        int[] input = {4,3,2,7,8,2,3,1};
        List<Integer> duplicates = findDuplicates(input);
        duplicates.stream().forEach(System.out::println);
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> numSet = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(!numSet.contains(nums[i])) {
                numSet.add(nums[i]);
            } else {
                result.add(nums[i]);
            }
        }

        return result;
    }
}
