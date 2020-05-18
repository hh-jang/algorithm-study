package baeck1010;

import java.math.BigInteger;
import java.util.Scanner;

public class Baeck1010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            System.out.println(solve(n, m));
        }
    }

    private static BigInteger solve(int n, int m) {
        if(m - n == 0) return factorial(m, BigInteger.ONE)
                .divide(factorial(n, BigInteger.ONE));
        return factorial(m, BigInteger.ONE)
                .divide(factorial(n, BigInteger.ONE))
                .divide(factorial(m - n, BigInteger.ONE));
    }

    private static BigInteger factorial(int n, BigInteger acc) {
        if(n == 1) return acc;
        return factorial(n - 1, acc.multiply(BigInteger.valueOf(Integer.valueOf(n))));
    }
}
