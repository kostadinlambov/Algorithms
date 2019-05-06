package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P01_Recursive_Array_Sum {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)));

        int[] numArr = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

//        System.out.println(Arrays.toString(numArr).replaceAll("[\\[\\]]", ""));

        int sum = sum(numArr, 0);
        System.out.println(sum);

    }

    public static int sum(int[] arr, int index) {
        if(index == arr.length){
            return 0;
        }

       int currentSum = arr[index] + sum(arr, index + 1);

        return currentSum;
    }
}
