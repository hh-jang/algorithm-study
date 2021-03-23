package programmers42860;

import java.util.HashMap;
import java.util.Map;

public class Programmers42860 {

    public static void main(String[] args) {
        String name = "BAABABA";
        System.out.println(solution(name));
    }

    public static int solution(String name) {
        int answer = 0;
        int left = 0;
        int right = 0;
        int idx = 0;
        int costOfRightMoving = 0;
        int costOfLeftMoving = 0;
        String copiedName = name;


        Map<Integer, Integer> convertCosts = new HashMap<>();
        for(int i = 0; i < name.length(); i++) {
            if(name.charAt(i) != 'A') convertCosts.put(i, getCost(name.charAt(i)));
        }

        do {
            costOfRightMoving = 0;
            costOfLeftMoving = 0;

            int cost = convertCosts.get(idx) == null ? 0 : convertCosts.get(idx);
            convertCosts.remove(idx);
            copiedName = copiedName.substring(0, idx) + 'A' + copiedName.substring(idx + 1);
            answer += cost;

            if(convertCosts.size() == 0) return answer;
            // wㅓㄴ체 7 0 -> 6 -> 5
            // (7 - left) % 7
            left = idx - 1 < 0 ? (name.length() - idx - 1) % name.length() : idx - 1;
            right = (idx + 1) % name.length();
            while ((copiedName.charAt(left) == 'A') && costOfLeftMoving < name.length()) {
                left = left - 1 < 0 ? (name.length() - 1) : left - 1;
                costOfLeftMoving++;
            }

            while ((copiedName.charAt(right) == 'A') && costOfRightMoving < name.length()) {
                if(right == name.length() - 1) costOfRightMoving = Integer.MAX_VALUE;
                right = (right + 1) % name.length();
                costOfRightMoving++;
            }
            if(costOfLeftMoving > costOfRightMoving) {
                idx = right;
                answer += costOfRightMoving + 1;
            } else {
                idx = left;
                answer += costOfLeftMoving + 1;
            }
        } while (convertCosts.size() > 0);


        return answer;
    }

    private static int getCost(char alphabet) {
        if(alphabet - 'A' > 'Z' - alphabet + 1) return 'Z' - alphabet + 1;
        return alphabet - 'A';
    }
}
