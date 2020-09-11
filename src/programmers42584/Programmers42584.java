package programmers42584;

import java.util.Arrays;

public class Programmers42584 {
    public static void main(String[] args) {
        int[] inputs = {1, 2, 3, 2, 3};
        int[] result = solution(inputs);

        Arrays.stream(result)
                .forEach(value -> System.out.println(value));
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i = 0; i < prices.length - 1; i++) {
            int currentPrice = prices[i];
            int days = 1;

            for(int j = i + 1; j < prices.length; j++) {
                if(currentPrice > prices[j]) {
                    answer[i] = days;
                    break;
                }
                if(j == prices.length - 1) answer[i] = days;
                days++;
            }
        }

        answer[prices.length - 1] = 0;

        return answer;
    }
}
