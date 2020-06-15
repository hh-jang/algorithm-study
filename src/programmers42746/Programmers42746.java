package programmers42746;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Programmers42746 {
    public static void main(String[] args) {
        int[] input = {34, 344};

        System.out.println(solve(input));
    }

    private static String solve(int[] input) {
        List<Number> numbers = new ArrayList<>();

        for(int i = 0; i < input.length; i++)
            numbers.add(new Number(input[i]));

        Collections.sort(numbers);

        StringBuilder sb = new StringBuilder();
        for(Number number : numbers)
            sb.append(number.getValue());

        if(allZero(sb.toString())) return "0";
        return sb.toString();
    }

    private static boolean allZero(String result) {
        for(int i = 0; i < result.length(); i++) {
            if (result.charAt(i) != '0') return false;
        }
        return true;
    }

    static class Number implements Comparable<Number>{
        private int value;

        public Number(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(Number o) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(value));
            sb.append(String.valueOf(o.getValue()));
            String originFirst = sb.toString();

            sb = new StringBuilder();
            sb.append(String.valueOf(o.getValue()));
            sb.append(String.valueOf(value));
            String otherFirst = sb.toString();

            if(Integer.parseInt(originFirst) > Integer.parseInt(otherFirst)) {
                return -1;
            } else if(Integer.parseInt(originFirst) < Integer.parseInt(otherFirst)) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
