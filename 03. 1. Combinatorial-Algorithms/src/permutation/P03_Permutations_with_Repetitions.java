package permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class P03_Permutations_with_Repetitions {

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
            HashSet<String> swapped = new HashSet<>();
            for (int i = index ; i < elements.length; i++) {
                if(!swapped.contains(elements[i])){
                    swap(index, i, elements);
                    gen(index + 1, elements);
                    swap(index, i, elements);
                    swapped.add(elements[i]);
                }
            }
        }
    }

    private static void swap(int index, int i, String[] elements) {
        String temp = elements[index];
        elements[index] = elements[i];
        elements[i] = temp;
    }
}
