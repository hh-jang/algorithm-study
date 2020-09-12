package leetcode.romantointeger;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static final Map<String, Integer> numbersOfRoman = new HashMap<>();

    static {
        numbersOfRoman.put("I", 1);
        numbersOfRoman.put("V", 5);
        numbersOfRoman.put("X", 10);
        numbersOfRoman.put("L", 50);
        numbersOfRoman.put("C", 100);
        numbersOfRoman.put("D", 500);
        numbersOfRoman.put("M", 1000);

        numbersOfRoman.put("IV", 4);
        numbersOfRoman.put("IX", 9);
        numbersOfRoman.put("XL", 40);
        numbersOfRoman.put("XC", 90);
        numbersOfRoman.put("CD", 400);
        numbersOfRoman.put("CM", 900);
    }

    public static void main(String[] args) {
        String input = "MCMXCIV";       // 1994
        System.out.println(solve(input));
    }

    public static int solve(String input) {
        int idx = 0;
        int result = 0;
        String key;

        while (idx < input.length()) {
            int numberOfRoman = 0;
            if(idx + 1 < input.length()) {
                key = input.substring(idx, idx + 2);
                if(numbersOfRoman.get(key) != null) numberOfRoman = numbersOfRoman.get(key);
            }

            if(numberOfRoman == 0) {
                key = input.substring(idx, idx + 1);
                numberOfRoman = numbersOfRoman.get(key);
                idx += 1;
            } else {
                idx += 2;
            }

            result += numberOfRoman;
        }

        return result;
    }
}
