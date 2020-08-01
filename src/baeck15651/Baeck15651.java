package baeck15651;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Baeck15651 {
    static int n;
    static int m;
    static ArrayList<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        dfs();

        System.out.print(sb.toString());
    }

    public static void dfs() {
        if(list.size() >= m) {
            for(int i = 0; i < list.size(); i++) {
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");

            return;
        }

        for(int i = 1; i <= n; i++) {
            if(list.size() < m) {
                list.add(i);
                dfs();
                list.remove(list.size() - 1);
            }
        }
    }
}
