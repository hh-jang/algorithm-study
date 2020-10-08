package programmerscheck.level3_1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class First {
    public static void main(String[] args) {
//        String[] operations = {"I 16","D 1"};
//        String[] operations = {"I 7","I 5","I -5","D -1"};
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        int[] solution = solution(operations);

        for(int i = 0; i < solution.length; i++) {
            System.out.println(solution[i]);
        }
    }

    public static int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        Map<Integer, Integer> valueCount = new HashMap<>();
        // 중복 가능해서 안댈듯
//        int left, right;

        for(int i = 0, length = operations.length; i < length; i++) {
            String operation = operations[i];
            String[] split = operation.split(" ");
            String opcode = split[0];
            String action = split[1];

            // insert
            if(opcode.equals("I")) {
                int number = Integer.parseInt(action);
                minHeap.add(number);
                maxHeap.add(number);

                if(valueCount.containsKey(number)) {
                    valueCount.put(number, valueCount.get(number) + 1);
                } else {
                    valueCount.put(number, 1);
                }
            } else {
                // remove max
                if(action.equals("1")) {
                    // 비어있지 않으면
                    while(maxHeap.size() > 0) {
                        int maxValue = maxHeap.poll();
                        if(valueCount.get(maxValue) > 0) {
                            valueCount.put(maxValue, valueCount.get(maxValue) - 1);
                            break;
                        }
                    }
//                    right = maxHeap.peek();
                } else {        // remove min
                    // 비어있지 않으면
                    while(minHeap.size() > 0) {
                        int minValue = minHeap.poll();
                        if(valueCount.get(minValue) > 0) {
                            valueCount.put(minValue, valueCount.get(minValue) - 1);
                            break;
                        }
                    }
//                    left = minHeap.peek();
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = 0;

        while (!maxHeap.isEmpty()) {
            int maxValue = maxHeap.poll();
            if(valueCount.get(maxValue) > 0) {
                answer[0] = maxValue;
                break;
            }
        }

        while (!minHeap.isEmpty()) {
            int minValue = minHeap.poll();
            if(valueCount.get(minValue) > 0) {
                answer[1] = minValue;
                break;
            }
        }

        return answer;
    }
}
