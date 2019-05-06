package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P02_Find_All_Paths_in_a_Labyrinth {
    private static char[][] labyrinth;
    private static List<Character> path = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        labyrinth = readLab();
        findPaths(0, 0, 'S');
    }

    private static void findPaths(int row, int col, char direction) {
        if(!isInBounds(row, col)){
            return;
        }

        path.add(direction);

        if(isExit(row, col)){
            printPath();
        }else if(!isVisited(row, col) && isFree(row, col)){
            Mark(row, col);
            findPaths(row, col +1, 'R');
            findPaths(row+1, col, 'D');
            findPaths(row, col -1, 'L');
            findPaths(row-1, col, 'U');
            UnMark(row, col);
        }

        path.remove(path.size()-1);
    }

    private static boolean isVisited(int row, int col) {
        return labyrinth[row][col] == 'v';
    }

    private static boolean isFree(int row, int col) {
        return labyrinth[row][col] == '-';
    }

    private static void Mark(int row, int col) {
        labyrinth[row][col] = 'v';
    }

    private static void UnMark(int row, int col) {
        labyrinth[row][col] = '-';
    }

    private static void printPath() {
        List<Character> characters = path.subList(1, path.size());
        System.out.println(Arrays.toString(characters.toArray())
                    .replaceAll("[\\[\\],\\s]", "")
            );
    }

    private static boolean isExit(int row, int col) {
        return labyrinth[row][col] == 'e';
    }

    private static boolean isInBounds(int row, int col) {
        return row >= 0 && row <= labyrinth.length - 1 &&
                col >= 0 && col <= labyrinth[0].length - 1;
    }

    private static char[][] readLab() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(reader.readLine());
        int cols = Integer.parseInt(reader.readLine());
        char[][] labyrinth = new char[rows][cols];

        for (int i = 0; i < rows ; i++) {
            char[] row = reader.readLine().toCharArray();
            labyrinth[i] = row;
        }

        return labyrinth;
    }
}
