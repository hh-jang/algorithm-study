package leetcode.brickwall;

import java.util.*;
import java.util.stream.Collectors;

public class BrickWall {

    public static void main(String[] args) {
//        Integer[][] input = {{1,2,2,1},
//                            {3,1,2},
//                            {1,3,2},
//                            {2,4},
//                            {3,1,2},
//                            {1,3,1,1}};

        Integer[][] input = {{1},{1},{1}};
        List<List<Integer>> collect = Arrays.stream(input).map(Arrays::asList).collect(Collectors.toList());
        int result = leastBricks(collect);

        System.out.println(result);
    }

    public static int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();

        for(List<Integer> brick : wall) {
            int currentBrickIdx = 0;

            for(int idx = 0; idx < brick.size() - 1; idx++) {
                currentBrickIdx += brick.get(idx);
                int currentPassValue = 0;
                if(map.get(currentBrickIdx) != null) currentPassValue = map.get(currentBrickIdx);

                map.put(currentBrickIdx, ++currentPassValue);
            }
        }

        if(map.values().size() == 0) return wall.size();

        return wall.size() - Collections.max(map.values());
    }
}
