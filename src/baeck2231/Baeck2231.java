package baeck2231;

import java.util.Scanner;

public class Baeck2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(solve(n));
    }

    private static int solve(int n) {
        for(int i = 0; i < n; i++) {
            String strValue = String.valueOf(i);
            int digitSum = 0;
            for(int j = 0; j < strValue.length(); j++) {
                digitSum += strValue.charAt(j)- '0';
            }
            if(i + digitSum == n) return i;
        }
        return 0;
    }
}
