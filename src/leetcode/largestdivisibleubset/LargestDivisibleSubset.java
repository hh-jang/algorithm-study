package leetcode.largestdivisibleubset;

import java.util.*;

public class LargestDivisibleSubset {

    public static void main(String[] args) {
//        int[] input = {1,2,3};
        int[] input = {2,4, 8, 9};
        List<Integer> integers = largestDivisibleSubset(input);
        integers.stream().forEach(System.out::println);
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<List<Integer>> dp = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            dp.add(list);
        }

        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                List<Integer> biggerSubSet = dp.get(j);
                if(biggerSubSet == null) {
                    biggerSubSet = new ArrayList<>();
                    biggerSubSet.add(nums[j]);
                    dp.set(j, biggerSubSet);
                }
                boolean isPossible = true;
                for(int k = 0; k < biggerSubSet.size(); k++) {
                    if(nums[i] % biggerSubSet.get(k) != 0 && biggerSubSet.get(k) % nums[i] != 0) {
                        isPossible = false;
                        break;
                    }
                }

                if(isPossible) {
                    List<Integer> integers = dp.get(i);
                    if(biggerSubSet.size() + 1 > integers.size()) {
                        integers = new ArrayList<>(biggerSubSet);
                        integers.add(nums[i]);
                    }
                    dp.set(i, integers);
                }
            }
        }

        List<Integer> result = null;
        int max = 0;

        for(int i = 0; i < nums.length; i++) {
            if(max < dp.get(i).size()) {
                result = dp.get(i);
                max = dp.get(i).size();
            }
        }

        return result;
    }

    static class SubSetInfo {
        Set<Integer> subSet = new HashSet<>();
    }
}
