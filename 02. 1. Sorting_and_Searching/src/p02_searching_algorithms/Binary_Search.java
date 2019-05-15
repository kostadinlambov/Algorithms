package p02_searching_algorithms;

import java.io.*;
import java.util.Arrays;

public class Binary_Search {
    private static int[] inputArr;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        inputArr = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int numberToFind = Integer.parseInt(reader.readLine());

        int index = binarySearchForValue(numberToFind);
        System.out.println(index);
    }

    private static int binarySearchForValue(int value) {
        int lowIndex = 0;
        int highIndex = inputArr.length - 1;

        while (true) {
            int middleIndex = (lowIndex + highIndex) / 2;

            if (lowIndex > highIndex) {
                return -1;
            }

            if (inputArr[middleIndex] < value) {
                lowIndex = middleIndex + 1;
            } else if (inputArr[middleIndex] > value) {
                highIndex = middleIndex - 1;
            } else if (lowIndex <= highIndex) {
                return middleIndex;
            }
        }
    }
}