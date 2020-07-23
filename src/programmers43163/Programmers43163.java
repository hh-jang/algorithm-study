package programmers43163;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Programmers43163 {
    private static Map<String, Boolean> cache = new HashMap<>();

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(solve(begin, target, words));
    }

    public static int solve(String begin, String target, String[] words) {
        int answer = 0;

        answer = bfs(begin, target, words);

        return answer;
    }

    private static int bfs(String begin, String target, String[] words) {
        Queue<Words> queue = new LinkedList<>();
        queue.add(new Words(begin, 0));
        cache.put(begin, true);

        while (queue.isEmpty() == false) {
            Words currentWord = queue.poll();
            String currentStr = currentWord.word;

            if(currentStr.equals(target)) return currentWord.depth;

            for(int i = 0; i < words.length; i++) {
                if(cache.get(words[i]) != null) continue;

                if(getNumberOfDifferenceChar(currentStr, words[i]) == 1) {
                    queue.add(new Words(words[i], currentWord.depth + 1));
                    cache.put(words[i], true);
                }
            }
        }

        return 0;
    }

    private static int getNumberOfDifferenceChar(String str1, String str2) {
        if(str1.length() != str2.length()) return -1;

        int result = 0;

        for(int i = 0; i < str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i)) result++;
        }

        return result;
    }

    static class Words{
        String word;
        int depth = 0;

        public Words(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }
}
