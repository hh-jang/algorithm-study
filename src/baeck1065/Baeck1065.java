package baeck1065;

import java.util.Scanner;

public class Baeck1065 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        System.out.println(solve(input));
    }

    private static int solve(int input) {
        int result = 0;
        for(int i = 1; i <= input; i++) {
            if(isHanNumber(i)) result++;
        }

        return result;
    }

    private static boolean isHanNumber(int i) {
        String strNumber = String.valueOf(i);
        if(strNumber.length() < 3) return true;

        char firstChar = strNumber.charAt(0);
        char secondChar = strNumber.charAt(1);
        int difference = Integer.parseInt(String.valueOf(firstChar)) - Integer.parseInt(String.valueOf(secondChar));
        char before = secondChar;

        for(int j = 2; j < strNumber.length(); j++) {
            char current = strNumber.charAt(j);
            if(Integer.parseInt(String.valueOf(before)) - Integer.parseInt(String.valueOf(current)) != difference) return false;
            before = current;
        }

        return true;
    }
}
