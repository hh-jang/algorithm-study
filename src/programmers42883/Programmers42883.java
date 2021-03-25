package programmers42883;

import java.math.BigInteger;

public class Programmers42883 {

//    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        String number = "4177252841";
        int k = 4;

        System.out.println(solution(number, k));
    }

    public static String solution(String number, int k) {
        String answer = "";
        String max = "0";
        max = combination(number, new boolean[number.length()], 0, new StringBuilder(), number.length() - k, max);
        return max;
    }

    public static String combination(String number, boolean[] visit, int start, StringBuilder sb, int k, String max) {
        if(sb.toString().length() == k) {
            max = getMax(max, sb);
            return max;
        }

        for(int i = start; i < number.length(); i++) {
            visit[i] = true;
            max = combination(number, visit, i + 1, sb.append(number.charAt(i)), k, max);
            sb.deleteCharAt(sb.length() - 1);
            visit[i] = false;
        }

        return max;
    }

    private static String getMax(String max, StringBuilder sb) {
        BigInteger a = new BigInteger(max);
        BigInteger b = new BigInteger(sb.toString());
        return a.compareTo(b) > 0 ? max : sb.toString();
    }
}
