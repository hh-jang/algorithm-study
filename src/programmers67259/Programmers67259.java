package programmers67259;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers67259 {
    enum Direction {
        LEFT(0, -1), RIGHT(0, 1), TOP(-1, 0), DOWN(1, 0);

        int diffX;
        int diffY;

        Direction(int diffX, int diffY) {
            this.diffX = diffX;
            this.diffY = diffY;
        }
    }
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};

        System.out.println(solution(board));
    }

    public static int solution(int[][] board) {
        int answer = dfs(board);

        return answer;
    }

    public static int dfs(int[][] board) {
        Queue<Vector> queue = new LinkedList<>();
        int maxX = board.length;
        int maxY = board[0].length;
        int[][] costs = new int[maxX][maxY];

        queue.add(new Vector(1, 0, Direction.DOWN));
        queue.add(new Vector(0, 1, Direction.RIGHT));

        costs[0][0] = -1;
        costs[1][0] = 200;
        costs[0][1] = 200;

        while (queue.isEmpty() == false) {
            Vector current = queue.poll();
            int x = current.x;
            int y = current.y;
            Direction beforeDirection = current.beforeDirection;

            for(Direction goTo : Direction.values()) {
                int diffX = goTo.diffX;
                int diffY = goTo.diffY;

                if(x + diffX >= 0 && x + diffX < maxX &&
                    y + diffY >= 0 && y + diffY < maxY) {
                    if(board[x + diffX][y + diffY]  == 0) {
                        int addedCost = beforeDirection == goTo ? 100 : 500;
                        boolean isCheap = costs[x + diffX][y + diffY] == 0 || costs[x + diffX][y + diffY] > costs[x][y] + addedCost ? true : false;

                        if(isCheap) {
                            if(costs[x + diffX][y + diffY] <= 0) {
                                costs[x + diffX][y + diffY] = costs[x][y] + addedCost;
                            } else {
                                costs[x + diffX][y + diffY] = Math.min(costs[x + diffX][y + diffY], costs[x][y] + addedCost);
                            }

                            queue.add(new Vector(x + diffX, y + diffY, goTo));
                        }
                    }
                }
            }
        }

        return costs[maxX - 1][maxY - 1];
    }

    static class Vector {
        int x;
        int y;
        Direction beforeDirection;

        public Vector(int x, int y, Direction beforeDirection) {
            this.x = x;
            this.y = y;
            this.beforeDirection = beforeDirection;
        }
    }
}
