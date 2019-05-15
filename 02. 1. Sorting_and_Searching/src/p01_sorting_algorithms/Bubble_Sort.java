package p01_sorting_algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bubble_Sort {
    private static int[] inputArr;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        inputArr = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = inputArr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (inputArr[j] > inputArr [j+1]){
                    swapValues(j , j+1);
                }
            }
        }

        System.out.println(Arrays.toString(inputArr)
                .replaceAll("[\\[\\],]", ""));
    }

    private static void swapValues(int indexOne, int indexTwo) {
        int temp = inputArr[indexOne];
        inputArr[indexOne]= inputArr[indexTwo];
        inputArr[indexTwo]= temp;
    }
}
