package p01_sorting_algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Selection_Sort {
    private static int[] inputArr;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        inputArr = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < inputArr.length; i++) {
            int min = i;
            for (int j = i; j < inputArr.length; j++) {
                if (inputArr[min] > inputArr[j]) {
                    min = j;
                }
            }

            swapValues(i, min);
        }

        System.out.println(Arrays.toString(inputArr)
                .replaceAll("[\\[\\],]", ""));
    }

    private static void swapValues(int indexOne, int indexTwo) {
        int temp = inputArr[indexOne];
        inputArr[indexOne] = inputArr[indexTwo];
        inputArr[indexTwo] = temp;
    }
}
