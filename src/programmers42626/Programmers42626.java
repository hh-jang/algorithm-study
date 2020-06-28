package programmers42626;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Programmers42626 {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 9, 10, 12};

//        System.out.println(solve(input, 8));
        System.out.println(solve(input, 7));
    }

    private static int solve(int[] scoville, int K) {
        int result = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++)
            queue.offer(scoville[i]);

        while (queue.size() > 1 && queue.peek() < K) {
            int firstMinimum = queue.poll();
            int secondMinimum = queue.poll();

            int newValue = firstMinimum + (secondMinimum * 2);
            queue.offer(newValue);
            result++;
        }

        if(queue.peek() < K) return -1;

        return result;
    }
}
