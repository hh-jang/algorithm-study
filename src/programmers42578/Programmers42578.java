package programmers42578;

import java.util.HashMap;
import java.util.Map;

public class Programmers42578 {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < clothes.length; i++) {
            String category = clothes[i][1];
            int currentCategoryCount = map.get(category) == null ? 0 : map.get(category);
            map.put(category, currentCategoryCount + 1);
        }
        for(String a : map.keySet()) {
            int cnt = map.get(a);
            answer *= (cnt + 1);
        }

        return answer - 1;
    }
}
