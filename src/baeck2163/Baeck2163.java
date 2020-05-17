package baeck2163;

import java.util.Scanner;

public class Baeck2163 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(solve(n ,m));
    }

    public static int solve(int n, int m) {
        return n * m - 1;
    }
}
