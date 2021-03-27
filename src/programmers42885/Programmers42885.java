package programmers42885;

import java.util.Arrays;

public class Programmers42885 {

    public static void main(String[] args) {
        int[] people = {70, 50, 80};
        int limit = 100;

        System.out.println(solution(people, limit));
    }

    public static int solution_bruteforce(int[] people, int limit) {
        int answer = 0;
        boolean[] visited = new boolean[people.length];
        int max;
        int maxIdx;

        for(int i = 0; i < people.length; i++) {
            if(visited[i] == true) continue;
            visited[i] = true;
            max = Integer.MIN_VALUE;
            maxIdx = -1;

            for(int j = i; j < people.length; j++) {
                if(visited[j] == true) continue;

                if((people[j] + people[i] <= limit) && max < people[j] + people[i]) {
                    maxIdx = j;
                    max = people[j] + people[i];
                }
            }

            if(maxIdx != -1) {
                visited[maxIdx] = true;
            }
            answer++;
        }

        return answer;
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;
        int head = 0;
        int tail = people.length - 1;

        Arrays.sort(people);

        while (head <= tail) {
            if(people[tail] <= limit / 2) {
                answer += Math.ceil((double)(tail - head + 1) / 2);
                break;
            }

            if(people[head] + people[tail] <= limit) {
                head++;
            }
            tail--;
            answer++;
        }

        return answer;
    }
}
