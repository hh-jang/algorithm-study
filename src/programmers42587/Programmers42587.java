package programmers42587;

import java.util.*;

public class Programmers42587 {

    public static void main(String[] args) {
//        int[] priorities = {2, 1, 3, 2};
        int[] priorities = {1, 1, 9, 1, 1, 1};

//        int location = 2;
        int location = 0;
        // then 1
        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        int priority;
        int maxPriority = Integer.MIN_VALUE;
        Queue<PrintOut> queue = new LinkedList<>();

        for(int i = 0; i < priorities.length; i++) {
            priority = priorities[i];
            if(maxPriority < priority) maxPriority = priority;
            queue.add(new PrintOut(priority, i));
        }

        while (!queue.isEmpty()) {
            PrintOut printOut = queue.poll();
            if(maxPriority <= printOut.priority) {
                answer++;
                if(printOut.idx == location) return answer;
                maxPriority = getMaxPriority(queue);
            } else {
                queue.add(printOut);
            }
        }

        return answer;
    }

    private static int getMaxPriority(Queue<PrintOut> queue) {
        int maxPriority = Integer.MIN_VALUE;
        List<PrintOut> list = new ArrayList<>(queue);

        for(PrintOut printOut : list) {
            if(maxPriority < printOut.priority) maxPriority = printOut.priority;
        }

        return maxPriority;
    }

    static class PrintOut {
        int priority;
        int idx;

        public PrintOut(int priority, int idx) {
            this.priority = priority;
            this.idx = idx;
        }
    }
}
