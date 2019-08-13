import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P02_Nested_Loops_To_Recursion {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());
        int[] vector = new int[number];
        printLoops(vector, 0);
    }

    private static void printLoops(int[] vector, int index) {
        if(index >= vector.length){
            System.out.println(Arrays.toString(vector).replaceAll("[\\[\\],]", ""));
            return;
        }

        for(int i = 1; i <= vector.length; i++){
            vector[index] = i;
            printLoops(vector, index + 1);
        }
    }
}
