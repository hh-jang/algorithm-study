package leetcode.combinationsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> lists = combinationSum(candidates, target);

        for(List<Integer> list: lists) {
            for(int val : list) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> tempList = new ArrayList<>();
        Arrays.sort(candidates);
        recursive(tempList, candidates, new ArrayList<>(), target, 0);
        return tempList;
    }

    public static void recursive(List<List<Integer>> result, int[] numbers, List<Integer> tempList, int remainForTarget, int start) {
        if(remainForTarget < 0) return ;

        if(remainForTarget == 0) {
            result.add(new ArrayList<>(tempList));
        }
        else {
            for(int i = start; i < numbers.length; i++){
                tempList.add(numbers[i]);
                recursive(result, numbers, tempList, remainForTarget - numbers[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
