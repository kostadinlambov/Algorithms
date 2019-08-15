import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

public class p03_Move_Down_Right_Sum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rowsCount = Integer.parseInt(reader.readLine());
        int colsCount = Integer.parseInt(reader.readLine());

        int[][] matrix = new int[rowsCount][colsCount];

        for (int rows = 0; rows < matrix.length; rows++) {
            matrix[rows] = Arrays.stream(reader.readLine()
                    .split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int row = 1; row < matrix.length; row++) {
            matrix[row][0] = matrix[row - 1][0] + matrix[row][0];
        }

        for (int col = 1; col < matrix.length; col++) {
            matrix[0][col] = matrix[0][col - 1] + matrix[0][col];
        }


        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix.length; col++) {

                matrix[row][col] = Math.max(matrix[row - 1][col], matrix[row][col - 1]) + matrix[row][col];
            }
        }

        int startCell = matrix[rowsCount - 1][colsCount - 1];
        int indexRow = rowsCount - 1;
        int indexCol = colsCount - 1;

        List<String> result = new ArrayList<>();

        result.add(String.format("[%d, %d]", rowsCount - 1, colsCount - 1));

        while (indexCol != 0 || indexRow != 0) {
            int top = -1;
            int left = -1;
            if (indexRow - 1 >= 0) {
                top = matrix[indexRow - 1][indexCol];
            }

            if (indexCol - 1 >= 0) {
                left = matrix[indexRow][indexCol - 1];
            }

            if (top > left) {
                result.add(String.format("[%d, %d]", indexRow - 1, indexCol));
                indexRow--;

            } else {
                result.add(String.format("[%d, %d]", indexRow , indexCol - 1));
                indexCol--;
            }
        }

        Collections.reverse(result);

        System.out.println(String.join(" ", result));
    }
}
