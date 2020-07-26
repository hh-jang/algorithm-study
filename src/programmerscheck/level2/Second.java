package programmerscheck.level2;

import java.util.Arrays;

public class Second {
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;

        System.out.println(solution(people, limit));
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;
        int idx = people.length - 1;

        Arrays.sort(people);

        for(int i = 0; i <= idx; i++, answer++) {
            while (idx > i && people[i] + people[idx--] > limit) {
                answer++;
            }
        }

        return answer;
    }
}
