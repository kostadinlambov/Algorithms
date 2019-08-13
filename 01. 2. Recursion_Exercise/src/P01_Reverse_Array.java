import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P01_Reverse_Array {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] inputArr = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] reversedArr = new int[inputArr.length];

        reverseArr(inputArr, 0, reversedArr);
    }

    private static void reverseArr(int[] inputArr, int index, int[] reversedArr) {

        if (index >= inputArr.length) {
            System.out.println(Arrays.toString(reversedArr).replaceAll("[\\[\\],]", ""));
            return;
        }
        reversedArr[inputArr.length - 1 - index] = inputArr[index];
        reverseArr(inputArr, index + 1, reversedArr);
    }
}
