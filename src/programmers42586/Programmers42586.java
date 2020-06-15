package programmers42586;

import java.util.ArrayList;
import java.util.List;

public class Programmers42586 {
    public static void main(String[] args) {
//        int[] progresses = {2, 2, 2, 5, 5, 1, 1, 5};
//        int[] speeds = {1, 1, 1, 1, 1, 1, 1, 1};

        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

//        int[] progresses = {2, 2, 2, 5, 5, 1, 1, 5};
//        int[] speeds = {1, 1, 1, 1, 1, 1, 1, 1};

        int[] result = solve(progresses, speeds);

        for(int value : result)
            System.out.println(value);
    }

    private static int[] solve(int[] progresses, int[] speeds) {
        int[] remainDays = getRemainDaysByProgressesAndSpeeds(progresses, speeds);
        List<Integer> result = new ArrayList<>();
        int beforeMaxValue = remainDays[0];
        int count = 1;

        if(progresses.length == 1) {
            result.add(count);
            return result.stream().mapToInt(i -> i).toArray();
        }

        for(int i = 1; i < remainDays.length; i++) {
            if(remainDays[i] > beforeMaxValue) {
                result.add(count);
                beforeMaxValue = remainDays[i];
                count = 1;
            } else {
                count++;
            }
        }

        result.add(count);

        return result.stream().mapToInt(i -> i).toArray();
    }

    private static int[] getRemainDaysByProgressesAndSpeeds(int[] progresses, int[] speeds) {
        int[] remainDays = new int[progresses.length];

        for(int i = 0; i < progresses.length; i++) {
            int currentPercentage = progresses[i];
            int speed = speeds[i];

            double remainDay = Math.ceil((100.0 - (double)currentPercentage) / (double)speed);
            remainDays[i] = (int)remainDay;
        }

        return remainDays;
    }
}
