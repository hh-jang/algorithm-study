package programmers42862;

import java.util.*;
import java.util.stream.Collectors;

public class Programmers42862 {

    public static void main(String[] args) {
        int n = 15;
        int[] lost = {2, 4, 10};
        int[] reserve = {1, 2, 4, 3, 5};

        int solution = solution(n, lost, reserve);
        System.out.println(solution);
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int borrowCount = 0;

        Set<Integer> reserveSet = new HashSet<>(Arrays.stream(reserve).boxed().collect(Collectors.toSet()));
        Set<Integer> lostSet = new HashSet<>(Arrays.stream(lost).boxed().collect(Collectors.toSet()));
        Set<Integer> copiedLostSet = new HashSet<>(lostSet);

        lostSet.removeAll(reserveSet);
        reserveSet.removeAll(copiedLostSet);

        for(int value : lostSet) {
            if(reserveSet.contains(value - 1)) {
                reserveSet.remove(value - 1);
                borrowCount++;
            } else if(reserveSet.contains(value + 1)) {
                reserveSet.remove(value + 1);
                borrowCount++;
            }
        }


        return n - lostSet.size() + borrowCount;
    }
}
