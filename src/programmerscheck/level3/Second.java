package programmerscheck.level3;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class Second {
    static int[][] diff = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};

        System.out.println(solution(m, n, puddles));
    }

    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[n][m];
        // 0 정상, 1 물
        for(int i = 0; i < puddles.length; i++) {
            map[puddles[i][0] - 1][puddles[i][0] - 1] = 1;
        }

        answer = dfs(map, n, m);

        return answer;

        // 코스트 동일
    }

    private static int dfs(int[][] map, int n, int m) {
        int result = 0;
        int max = Integer.MAX_VALUE;
        Queue<Point> queue = new LinkedList<>();
        Point[][] visited = new Point[n][m];

        queue.add(new Point(0, 0));

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                visited[i][j] = new Point();

        // x 코스트, y 도달 방법
        visited[0][0].x = 1;
        visited[0][0].y = 1;

        while (queue.isEmpty() == false) {
            Point poll = queue.poll();
            int currentN = poll.x;
            int currentM = poll.y;

            for(int k = 0; k < 4; k++) {
                int xDiff = diff[k][0];
                int yDiff = diff[k][1];

                int modifiedN = currentN + xDiff;
                int modifiedM = currentM + yDiff;

                if(modifiedN >= 0 && modifiedN < m &&
                        modifiedM >= 0 && modifiedM < n){
                    if(map[modifiedN][modifiedM] == 0){
                        if(visited[modifiedN][modifiedM].x == visited[currentN][currentM].x + 1) {
                            queue.add(new Point(modifiedN, modifiedM));
                            visited[modifiedN][modifiedM].x = 1 + visited[currentN][currentM].x;        // 코스트
                            visited[modifiedN][modifiedM].y++;                                          // count
                        } else if (visited[modifiedN][modifiedM].x > visited[currentN][currentM].x + 1) {
                            queue.add(new Point(modifiedN, modifiedM));
                            visited[modifiedN][modifiedM].x = visited[currentN][currentM].x;        // 코스트
                            visited[modifiedN][modifiedM].y = 1;
                        }
                    }
                }
            }
        }

        return visited[n-1][m-1].y;
    }
}
