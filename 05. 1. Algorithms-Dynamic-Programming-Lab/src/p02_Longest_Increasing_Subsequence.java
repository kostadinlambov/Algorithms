import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p02_Longest_Increasing_Subsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

//        int[] numbers = new int[]{3, 14, 5, 12, 15, 7, 8, 9, 11, 10, 1};
        int[] lengthArr = new int[numbers.length];
        int[] prev = new int[numbers.length];

        int maxLength = 1;
        int maxNumberIndex = 0;

        for (int currentIndex = 0; currentIndex < numbers.length; currentIndex++) {
            lengthArr[currentIndex] = 1;
            prev[currentIndex] = -1;
            int currentNumber = numbers[currentIndex];
            int currentNumLength = lengthArr[currentIndex];

            for (int previousIndex = 0; previousIndex <= currentIndex - 1; previousIndex++) {
                int previousNum = numbers[previousIndex];
                int prevNumLength = lengthArr[previousIndex];

                if (currentNumber > previousNum && currentNumLength < prevNumLength + 1) {
                    lengthArr[currentIndex] = prevNumLength + 1;
                    prev[currentIndex] = previousIndex;
                    currentNumLength++;
                }
            }

            if (currentNumLength > maxLength) {
                maxLength = currentNumLength;
                maxNumberIndex = currentIndex;
            }
        }
        List<Integer> result = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        int index = maxNumberIndex;

        while(index != -1){
            int currentNum = numbers[index];
            result.add(currentNum);
            index =  prev[index];
        }

        for (int i = result.size()-1 ; i >= 0 ; i--) {
            sb.append(result.get(i)+ " ");
        }

        System.out.println(sb.toString().trim());
    }
}
