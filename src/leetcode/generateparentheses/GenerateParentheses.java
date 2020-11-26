package leetcode.generateparentheses;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        strings.forEach(System.out::println);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        recursiveGenerateParenthesis("", 0, 0, n * 2, result);
        return result;
    }

    public static void recursiveGenerateParenthesis(String subStr, int leftCount, int rightCount, int maxlength, List<String> result) {
        if(subStr.length() == maxlength && leftCount == rightCount && leftCount == maxlength / 2) {
            result.add(subStr);
            return;
        }

        if(leftCount < maxlength / 2) {
            recursiveGenerateParenthesis(subStr + "(", leftCount + 1, rightCount, maxlength, result);
        }

        if(rightCount < leftCount) {
            recursiveGenerateParenthesis(subStr + ")", leftCount, rightCount + 1, maxlength, result);
        }
    }
}
