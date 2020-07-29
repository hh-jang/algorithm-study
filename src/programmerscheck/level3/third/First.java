package programmerscheck.level3.third;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class First {
    static List<Peoples> list = new ArrayList<>();

    public static void main(String[] args) {
        int[] solution = solution(3, 5);

        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution[i]);
        }
    }

    public static int[] solution(int n, long k) {
        int[] answer = {};
        int[] input = new int[n];

        for(int i = 0; i < n; i++) {
            input[i] = i + 1;
        }

        permutation(input, 0, n, n);

        Collections.sort(list);

        return list.get(Integer.parseInt(String.valueOf(k-1))).people.stream().mapToInt(i -> i).toArray();
    }

    static void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            Peoples peoples = new Peoples(new ArrayList<>());
            for (int i = 0; i < r; i++) {
                peoples.people.add(arr[i]);
            }

            list.add(peoples);
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    static class Peoples implements Comparable<Peoples>{
        List<Integer> people;

        public Peoples(List<Integer> people) {
            this.people = people;
        }

        @Override
        public int compareTo(Peoples o) {
            List<Integer> others = o.people;

            for(int i = 0; i < others.size(); i++) {
                if(this.people.get(i) > others.get(i)) return 1;
                else if(this.people.get(i) < others.get(i)) return -1;
            }

            return 0;
        }
    }
}
