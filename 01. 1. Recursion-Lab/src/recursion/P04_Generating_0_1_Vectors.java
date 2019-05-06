package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P04_Generating_0_1_Vectors {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        int[] vector = new int[number];

        generateVectors(0, vector);
    }

    private static void generateVectors(int index, int[] vector) {
        if (index >= vector.length) {
            System.out.println(Arrays.toString(vector).replaceAll("[\\[\\],\\s]", ""));
            return;
        }

        for (int i = 0; i <= 1; i++){

            vector[index] = i;
            generateVectors(index +1, vector);
        }
    }
}
