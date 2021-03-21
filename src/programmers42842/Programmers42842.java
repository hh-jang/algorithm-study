package programmers42842;

import java.util.Arrays;

public class Programmers42842 {

    public static void main(String[] args) {
        int brown = 24;
        int yellow = 24;

        int[] result = solution(brown, yellow);

        Arrays.stream(result).forEach(System.out::println);
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int x = 0;
        int y = 0;

        // brown으로 둘레를 알수있으므로 가로 세로를 추론할 수 있고
        // yellow edge를 제외한 넓이이므로 가로 세로를 추론할 수 있다.
//        2 * x + 2 * y - 4 == brown;
//        (x - 2) * (y - 2) == yellow;

        for(int i = 3; i <= (brown - 2) / 2; i++) {
            for(int j = 3; j <= (brown - 2) / 2; j++) {
                if((2 * i + 2 * j - 4) == brown && ((i - 2) * (j - 2) == yellow)) {
                    x = i;
                    y = j;

                    break;
                }
            }
        }

        answer[0] = x >= y ? x : y;
        answer[1] = x < y ? x : y;

        return answer;
    }
}
