package backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P01_8_Queens_Puzzle {
    private static int SIZE = 8;
    private static boolean[][] chessboard = new boolean[SIZE][SIZE];
    private static Set<Integer> attackedRows = new HashSet<>();
    private static Set<Integer> attackedColumns = new HashSet<>();
    private static Set<Integer> attackedLeftDiagonals = new HashSet<>();
    private static Set<Integer> attackedRightDiagonals = new HashSet<>();

    public static void main(String[] args) {
        puTQueens(0);
    }

    private static void puTQueens(int row) {
        if (row == SIZE) {
            printSolution();
        } else {
            for (int col = 0; col < SIZE; col++) {
                if (canPlaceQueen(row, col)) {
                    MarkAllAttackedPositions(row, col);
                    puTQueens(row + 1);
                    UnMarkAllAttackedPositions(row, col);
                }
            }
        }
    }

    private static boolean canPlaceQueen(int row, int col) {
        return !attackedRows.contains(row) &&
                !attackedColumns.contains(col) &&
                !attackedLeftDiagonals.contains(col - row) &&
                !attackedRightDiagonals.contains(col + row);
    }

    private static void UnMarkAllAttackedPositions(int row, int col) {
        attackedRows.remove(row);
        attackedColumns.remove(col);
        attackedLeftDiagonals.remove(col - row);
        attackedRightDiagonals.remove(col + row);
        chessboard[row][col] = false;
    }

    private static void MarkAllAttackedPositions(int row, int col) {
        attackedRows.add(row);
        attackedColumns.add(col);
        attackedLeftDiagonals.add(col - row);
        attackedRightDiagonals.add(col + row);
        chessboard[row][col] = true;
    }

    private static void printSolution() {
        for (boolean[] booleans : chessboard) {
            System.out.println(Arrays.toString(booleans)
                    .replaceAll("[\\[\\],]", "")
                    .replaceAll("true", "*")
                    .replaceAll("false", "-")
            );
        }
        System.out.println();
    }
}
