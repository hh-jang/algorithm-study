package programmers42629;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Programmers42629 {
    public static void main(String[] args) {
        int stock = 4;
        int[] dates = {4, 10, 15, 30};
        int[] supplies = {26, 5, 10, 10};
        int k = 30;

        System.out.println(solve(stock, dates, supplies, k));
    }

    private static int solve(int stock, int[] dates, int[] supplies, int k) {
        int remain = stock;
        int index = 0;
        int result = 0;
        PriorityQueue<Integer> possibleQueue = new PriorityQueue<Integer>(Comparator.reverseOrder());

        for(int i = 0; i < k; i++) {
            if(index < dates.length && dates[index] == i) {
                possibleQueue.add(supplies[index]);
                index++;
            }

            if(remain == i) {
                remain += possibleQueue.poll();
                result++;
            }
        }

        return result;
    }
}
