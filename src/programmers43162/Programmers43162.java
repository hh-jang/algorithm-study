package programmers43162;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Programmers43162 {
    private static Map<Integer, Boolean> cache = new HashMap<Integer, Boolean>();

    public static void main(String[] args) {
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int n = 3;

        System.out.println(solution(n, computers));
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;

        for(int i = 0; i < n; i++) {
            if(cache.get(i) == null) {
                bfs(computers, i);
                answer++;
            }
        }

        return answer;
    }

    private static void bfs(int[][] computers, int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        cache.put(i, true);

        while (queue.isEmpty() == false) {
            int currentComputer = queue.poll();

            for(int j = 0; j < computers.length; j++) {
                if(i == j || cache.get(j) != null) continue;

                if(computers[currentComputer][j] == 1) {
                    queue.add(j);
                    cache.put(j, true);
                }
            }
        }
    }
}
