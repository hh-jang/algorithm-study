package programmerscheck.level2;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class First {
    static int[][] diff = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

        int[] solution = solution(m, n, picture);

        for (int value : solution)
            System.out.println(value);
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j] == false && picture[i][j] != 0) {
                    int areaOfSize = dfs(i, j, picture, visited, m, n);
                    numberOfArea++;

                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, areaOfSize);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }

    private static int dfs(int i, int j, int[][] picture, boolean[][] visited, int m, int n) {
        int size = 1;
        int color = picture[i][j];

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j));
        visited[i][j] = true;

        while (queue.isEmpty() == false) {
            Point current = queue.poll();
            int x = current.x;
            int y = current.y;

            for(int k = 0; k < 4; k++) {
                int xDiff = diff[k][0];
                int yDiff = diff[k][1];

                int modifiedX = x + xDiff;
                int modifiedY = y + yDiff;

                if(modifiedX >= 0 && modifiedX < m &&
                        modifiedY >= 0 && modifiedY < n){
                    if(picture[modifiedX][modifiedY] == color &&
                            visited[modifiedX][modifiedY] == false) {
                        queue.add(new Point(modifiedX, modifiedY));
                        visited[modifiedX][modifiedY] = true;
                        size++;
                    }

                }
            }
        }
        return size;
    }
}
