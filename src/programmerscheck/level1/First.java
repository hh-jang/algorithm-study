package programmerscheck.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class First {
    public static void main(String[] args) {
        int[] arr = {5, 9, 7, 10};
        int divisor = 5;

        int[] values = solution(arr, divisor);
        for(int value : values) {
            System.out.println(value);
        }
    }

    public static int[] solution(int[] arr, int divisor) {
        List<Integer> answer = new ArrayList<>();

        for(int value : arr) {
            if(value % divisor == 0) answer.add(value);
        }
        if(answer.size() < 1) answer.add(-1);

        Collections.sort(answer);

        return answer.stream().mapToInt(i->i).toArray();
    }
}
