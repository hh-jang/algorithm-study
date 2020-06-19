package programmers42840;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Programmers42840 {
    public static void main(String[] args) {
        int[] answers = {1,2,3,4,5};
        int[] result = solve(answers);

        for (int value : result)
            System.out.println(value);
    }

    private static int[] solve(int[] answers) {
        int[] student = new int[3];

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == i % 5 + 1) student[0]++;
            if(answers[i] == getSecondStudentAnswerByIndex(i)) student[1]++;
            if(answers[i] == getThirdStudentAnswerByIndex(i)) student[2]++;
        }

        return getMaximumScoreStudent(student);
    }

    private static int[] getMaximumScoreStudent(int[] student) {
        int maxScore = Integer.MIN_VALUE;
        List<Integer> result = new LinkedList<>();

        for(int i = 0; i < 3; i++) {
            if(student[i] > maxScore) {
                maxScore = student[i];
                result.clear();
                result.add(i + 1);
            } else if(student[i] < maxScore) {
                continue;
            } else {
                result.add(i + 1);
            }
        }

        Collections.sort(result);

        return result.stream().mapToInt(i -> i).toArray();
    }

    private static int getSecondStudentAnswerByIndex(int i) {
        int[] template = {2, 1, 2, 3, 2, 4, 2, 5};
        return template[i % template.length];
    }

    private static int getThirdStudentAnswerByIndex(int i) {
        int[] template = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        return template[i % template.length];
    }
}
