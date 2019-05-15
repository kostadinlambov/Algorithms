package p01_sorting_algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Insertion_Sort {
    private static int[] inputArr;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        inputArr = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < inputArr.length; i++) {
            int j = i;

            int toInsert = inputArr[i];

            while((j > 0) && (inputArr[j-1] > toInsert)){
                inputArr[j] = inputArr[j-1];
                j--;
            }

            inputArr[j] = toInsert;
        }

        System.out.println(Arrays.toString(inputArr)
                .replaceAll("[\\[\\],]", ""));
    }
}

