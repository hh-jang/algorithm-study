package programmers42583;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers42583 {
    public static void main(String[] args) {
        int bridgeLength = 4;
        int weight = 2;
        int[] truckWeights = {1,1,1, 1};

        System.out.println(solve(bridgeLength, weight, truckWeights));
    }

    private static int solve(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Truck> queue = new LinkedList<>();
        int result = 0;
        int beforeEnteredSecond = 0;

        for(int i = 0; i < truckWeights.length; i++) {
            Truck truck = new Truck(truckWeights[i], ++result);

            if(queue.isEmpty() || isPossibleEnterTruck(truck, queue, weight)) {
                queue.add(truck);
                System.out.println("i : " + i + " weight : " +truckWeights[i] + " enteredTime : " + truck.getEnteredSecond());
            } else {
                while (isPossibleEnterTruck(truck, queue, weight) == false) {
                    Truck firstTruck = queue.poll();
                    result = firstTruck.getEnteredSecond() + bridgeLength;
                }
                if(result == beforeEnteredSecond) result = beforeEnteredSecond + 1;
                truck.setEnteredSecond(result);
                System.out.println("i : " + i + " weight : " +truckWeights[i] + " enteredTime : " + truck.getEnteredSecond());
                queue.add(truck);
            }

            beforeEnteredSecond = result;
        }

        return result + bridgeLength;
    }

    private static boolean isPossibleEnterTruck(Truck truck, Queue<Truck> queue, int weight) {
        return truck.getWeight() + queue.stream().mapToInt(Truck::getWeight).sum() <= weight;
    }

    static class Truck {
        private int weight;
        private int enteredSecond;

        public Truck(int weight, int enteredSecond) {
            this.weight = weight;
            this.enteredSecond = enteredSecond;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getEnteredSecond() {
            return enteredSecond;
        }

        public void setEnteredSecond(int enteredSecond) {
            this.enteredSecond = enteredSecond;
        }
    }
}
