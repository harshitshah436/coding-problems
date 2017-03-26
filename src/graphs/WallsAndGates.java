/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
You are given a m x n 2D grid initialized with these three possible values.

-1 : A wall or an obstacle.
0 : A gate.

Fill each empty room with the distance to its nearest gate. If it is impossible 
to reach a gate, it should be filled with INF.

For example, given the 2D grid:

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
 After running your function, the 2D grid should be:

  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
 */
/**
 *
 * Ref: http://www.cnblogs.com/jcliBlogger/p/4836567.html
 *
 * @author Harshit
 */
public class WallsAndGates {

    public static final int INF = Integer.MAX_VALUE;
    public static final int ROW_NUM = 4, COL_NUM = 4;

    private static void bfsGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    Queue<GRID> queue = new LinkedList();
                    queue.add(new GRID(i - 1, j, 1));
                    queue.add(new GRID(i + 1, j, 1));
                    queue.add(new GRID(i, j + 1, 1));
                    queue.add(new GRID(i, j - 1, 1));

                    while (!queue.isEmpty()) {
                        GRID elem = queue.poll();
                        if (elem.row < 0 || elem.row >= ROW_NUM || elem.column < 0 || elem.column >= COL_NUM || grid[elem.row][elem.column] < elem.distance) {
                            continue;
                        }
                        grid[elem.row][elem.column] = elem.distance;
                        queue.add(new GRID(elem.row - 1, elem.column, elem.distance + 1));
                        queue.add(new GRID(elem.row + 1, elem.column, elem.distance + 1));
                        queue.add(new GRID(elem.row, elem.column + 1, elem.distance + 1));
                        queue.add(new GRID(elem.row, elem.column - 1, elem.distance + 1));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[ROW_NUM][COL_NUM];

        grid[0][0] = INF;
        grid[0][1] = -1;
        grid[0][2] = 0;
        grid[0][3] = INF;
        grid[1][0] = INF;
        grid[1][1] = INF;
        grid[1][2] = INF;
        grid[1][3] = -1;
        grid[2][0] = INF;
        grid[2][1] = -1;
        grid[2][2] = INF;
        grid[2][3] = -1;
        grid[3][0] = 0;
        grid[3][1] = -1;
        grid[3][2] = INF;
        grid[3][3] = INF;

        System.out.println("Give 2D grid: ");
        printGrid(grid);
        System.out.println("==============");

        bfsGrid(grid);
        
        System.out.println("After calculating minimum distance from the gates: ");
        printGrid(grid);
    }

    private static void printGrid(int[][] grid) {
        for (int i = 0; i < ROW_NUM; i++) {
            for (int j = 0; j < COL_NUM; j++) {
                System.out.print(grid[i][j] + "\t");
            }
            System.out.println();
        }
    }

    static class GRID {

        int row, column, distance;

        public GRID(int row, int column, int distance) {
            this.row = row;
            this.column = column;
            this.distance = distance;
        }
    }

}
