package leetcode.integertoroman;

public class IntegerToRoman {
    private static int[] numberToRoman = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static String[] stringToRoman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static void main(String[] args) {
        int value = 1994;
        System.out.println(intToRoman(value));
    }

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int length = numberToRoman.length;

        while(idx < length) {
            int numberOfUnit = num / numberToRoman[idx];

            for(int i = 0; i < numberOfUnit; i++) {
                sb.append(stringToRoman[idx]);
            }

            num -= numberOfUnit * numberToRoman[idx];
            idx++;
        }

        return sb.toString();
    }
}
