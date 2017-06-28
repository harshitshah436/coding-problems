package tricky_problems;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Check if a given string (contains moves) is a circular or not for a robot.
 *
 * Initial position: (0, 0)
 * G - Go one unit, L- turn left, R-Turn right (do not go ahead while L & R, just change direction)
 *
 * Ref: http://www.geeksforgeeks.org/check-if-a-given-sequence-of-moves-for-a-robot-is-circular-or-not/
 *
 * @author Harshit
 */
public class CircularRobotMoves {

    private static boolean isCircular(String path) {

        // Directions
        final int N = 0; // north
        final int E = 1; // east
        final int S = 2; // south
        final int W = 3; // west

        // Initial position
        int x = 0, y = 0; // (0,0) coordinate;
        int dir = N;

        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'R') {
                dir = (dir + 1) % 4;
            } else if (path.charAt(i) == 'L') {
                dir = (4 + dir - 1) % 4;
            } else { // 'G' go 1 unit forward
                switch (dir) {
                    case N:
                        y++;
                        break;
                    case E:
                        x++;
                        break;
                    case S:
                        y--;
                        break;
                    case W:
                        x--;
                        break;
                }
            }
        }

        return (x == 0 && y == 0);
    }

    private static void checkAndPrintResult(String path) {
        if (isCircular(path)) {
            System.out.println("Given sequence of moves is circular");
        } else {
            System.out.println("Given sequence of moves is NOT circular");
        }
    }

    public static void main(String[] args) {
        String path = "GLGLGLG";
        checkAndPrintResult(path);

        path = "GLLG";
        checkAndPrintResult(path);

        path = "GRGL";
        checkAndPrintResult(path);

        path = "L";
        checkAndPrintResult(path);
    }

}
