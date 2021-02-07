package leetcode.maximumproductofordlength;

import java.util.HashSet;
import java.util.Set;

public class MaximumProductOfWordLengths {

    public static void main(String[] args) {
//        String[] inputs = {"abcw","baz","foo","bar","xtfn","abcdef"};
//        String[] inputs = {"a","ab","abc","d","cd","bcd","abcd"};
//        String[] inputs = {"a","aa","aaa","aaaa"};
//        String[] inputs = {"eae","ea","aaf","bda","fcf","dc","ac","ce","cefde","dabae"};
        String[] inputs = {"fcf","dabae"};

        int result = maxProduct(inputs);
        System.out.println(result);
    }

    public static int maxProduct(String[] words) {
        int result = 0;

        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            String compareValue;

            for(int j = i + 1; j < words.length; j++) {
                compareValue = words[j];

                if(isUnique(word, compareValue)) {
                    int len = word.length() * compareValue.length();
                    result = Math.max(result, len);
                }
            }
        }

        return result;
    }

    private static boolean isUnique(String word, String compareValue) {
        Set<Character> characterSet = new HashSet<>();
        char charValue;

        for(int i = 0; i < word.length(); i++) {
            charValue = word.charAt(i);
            characterSet.add(charValue);
        }

        for(int i = 0; i < compareValue.length(); i++) {
            charValue = compareValue.charAt(i);
            if(characterSet.contains(charValue)) {
                return false;
            }
        }

        return true;
    }
}
