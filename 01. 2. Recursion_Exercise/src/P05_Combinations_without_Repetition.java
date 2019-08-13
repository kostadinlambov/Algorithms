import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P05_Combinations_without_Repetition {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int dimension = Integer.parseInt(reader.readLine());
        int resultArrLength = Integer.parseInt(reader.readLine());
        int[] result = new int[resultArrLength];

        int[] numberArr = new int[dimension];

        for (int i = 0; i < numberArr.length; i++) {
            numberArr[i] = i + 1;
        }
        genComb(numberArr, result, 0, 0);
    }

    private static void genComb(int[] numberArr, int[] result, int index, int border) {
        if (index >= result.length) {
            System.out.println(Arrays.toString(result).replaceAll("[\\[\\],]", ""));
            return;
        }else{
            for (int i = border; i < numberArr.length; i++) {
                result[index] = numberArr[i];
                genComb(numberArr, result, index + 1, i + 1);
            }
        }


    }
}
