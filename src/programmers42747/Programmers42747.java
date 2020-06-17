package programmers42747;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Programmers42747 {
    public static void main(String[] args) {
        int[] citations = {0, 0, 0, 0};

        System.out.println(solve(citations));
    }

    // x축 : 논문 수, y축 : 논문의 인용수라고 생각
    // h의 최대값을 구하는 거니까 n - h를 인덱스로 잡아 0까지 루프하여 구함(직사각형이상(??) - > 위로 커지는 지점을 찾는다)
    private static int solve(int[] citations) {
        int n = citations.length;
        int h = n;
        List<Integer> list = Arrays.stream(citations).boxed().collect(Collectors.toList());

        Collections.sort(list);

        while (h > 0) {
            int value = list.get(n - h);
            if(value >= h) return h;
            h--;
        }

        return 0;
    }
}
