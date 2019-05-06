package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P05_Generating_Combinations {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] setOfNum = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int dimension = Integer.parseInt(reader.readLine());

        int[] resultArr = new int[dimension];

        genComb(setOfNum, resultArr, 0, 0);
    }

    private static void genComb(int[] setOfNum, int[] resultArr, int index, int border) {
        if (index >= resultArr.length) {
            System.out.println(Arrays.toString(resultArr).replaceAll("[\\[\\],]", ""));
            return;
        } else {

            for (int i = border; i < setOfNum.length; i++) {
                resultArr[index] = setOfNum[i];
                genComb(setOfNum, resultArr, index + 1, i + 1);
            }
        }
    }
}
