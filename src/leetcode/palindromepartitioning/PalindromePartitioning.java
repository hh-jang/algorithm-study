package leetcode.palindromepartitioning;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String[] args) {
//        String input = "aab";
        String input = "abbac";
        List<List<String>> partition = partition(input);
        partition.stream().forEach(strings -> System.out.println(String.join(", ", strings)));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtracking(0 , new ArrayList<>(), result, s);
        return result;
    }

    public static void backtracking(int start, List<String> currentList, List<List<String>> result, String s) {
        if(start >= s.length()) result.add(new ArrayList<>(currentList));

        for(int i = start; i < s.length(); i++) {
            if(isPalindrome(start, i, s)) {
                currentList.add(s.substring(start, i + 1));
                backtracking(i + 1, currentList, result, s);
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(int start, int i, String s) {
        if(start == i) return true;
        while (start < i) {
            if(s.charAt(start++) != s.charAt(i--)) return false;
        }

        return true;
    }
}
