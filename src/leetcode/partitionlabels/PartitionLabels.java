package leetcode.partitionlabels;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    public static void main(String[] args) {
        String input = "vhaagbqkaq";
        List<Integer> integers = partitionLabels(input);
        integers.stream().forEach(integer -> System.out.println(integer));
    }

    public static List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        int[] lastIndex = new int['z' - 'a' + 1];
        // 파티션 길이
        int lengthOfPartition = 0;
        // 파티션을 이루는 character들 중 가장 오른쪽에 index
        int lastIndexOfPartitionCharacters = 0;

        // 각 문자별 가장 오른쪽에 가까운 index를 저장
        for(int i = 0; i < S.length(); i++) {
            lastIndex[S.charAt(i) - 'a'] = i;
        }

        // 문자를 방문하면서 구성원 중 가장 오른쪽에 가까운 index를 업데이트, 최종적으로 도달하면 partition 저장
        for(int i = 0; i < S.length(); i++) {
            lastIndexOfPartitionCharacters = Math.max(lastIndexOfPartitionCharacters, lastIndex[S.charAt(i) - 'a']);
            lengthOfPartition++;

            if(i == lastIndexOfPartitionCharacters) {
                result.add(lengthOfPartition);
                lengthOfPartition = 0;
                lastIndexOfPartitionCharacters = 0;
            }
        }

        return result;
    }
}
