package baeck6603;

import java.util.Scanner;

public class Baeck6603 {

    public static final int MAX_NUM = 6;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        int[] array;

        while(true) {
            n = sc.nextInt();
            if(n == 0) break;

            array = new int[n];

            for(int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }

            solve(array, n);
        }
    }

    public static void solve(int[] array, int n) {

    }

    public static void some(int idx, int[] array) {
        if(idx >= array.length) return;
        System.out.println(array[idx]);
        some(idx++, array);
    }
}
