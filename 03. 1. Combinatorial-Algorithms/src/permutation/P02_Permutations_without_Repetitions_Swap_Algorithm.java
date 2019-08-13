package permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P02_Permutations_without_Repetitions_Swap_Algorithm {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        String[] elements = new String[input.length];

        for (int i = 0; i < input.length; i++) {
            elements[i] = input[i];
        }

        gen(0, elements);
    }

    private static void gen(int index, String[] elements) {
        if (index >= elements.length) {
            System.out.println(Arrays.toString(elements).replaceAll("[\\[\\],]", ""));
        } else {
            gen(index + 1, elements);
            for (int i = index + 1; i < elements.length; i++) {
                swap(index, i, elements);
                gen(index + 1, elements);
                swap(index, i, elements);
            }
        }
    }

    private static void swap(int index, int i, String[] elements) {
        String temp = elements[index];
        elements[index] = elements[i];
        elements[i] = temp;
    }
}
