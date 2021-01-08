package leetcode.longestsubstringwithatleastkrepeatingcharacters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Longest Substring with At Least K Repeating Characters
// https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
public class LongestSubstringWithAtLeastKRepeatingCharacters {

    public static void main(String[] args) {
        String s = "aaabb";
        int k = 3;

        int result = longestSubstring(s, k);
        System.out.println(result);
    }

    public static int longestSubstring(String s, int k) {
        return recursive(s, k);
    }

    // 1. String의 구성 character 중 k보다 낮은 Character 구한다
    // 2. String의 구성요소를 검사하면서 (1)의 Character를 만나면 기준점이 되어 재귀한다.
    // 3. (1)의 Character를 만나지 않으면 length를 구하여 return한다
    public static int recursive(String s, int k) {
        Map<Integer, Integer> repeatCountMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            Integer count = repeatCountMap.get(s.charAt(i) - 'a');
            if(count == null) count = 0;
            count++;
            repeatCountMap.put(s.charAt(i) - 'a', count);
        }

        Set<Integer> repeatCountlessThanKSet = new HashSet<>();

        for(int key : repeatCountMap.keySet()) {
            Integer repeatCount = repeatCountMap.get(key);
            if(repeatCount < k) {
                repeatCountlessThanKSet.add(key);
            }
        }

        int maxLength = 0;
        int currentLength = 0;

        for(int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if(repeatCountlessThanKSet.contains(idx)) {
                return Math.max(recursive(s.substring(0, i), k), recursive(s.substring(i + 1), k));
            }
            currentLength++;
        }

        return currentLength;
    }
}
