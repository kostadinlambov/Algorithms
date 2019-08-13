package permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P01_Permutations_without_Repetitions {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        String[] elements = new String[input.length];
        boolean[] used = new boolean[input.length];
        String[] perm = new String[input.length];

        for (int i = 0; i < input.length; i++) {
            elements[i] = input[i];

        }

        gen(0, elements, used, perm);
    }

    private static void gen(int index, String[] elements, boolean[] used, String[] perm) {
        if (index >= elements.length) {
            System.out.println(Arrays.toString(perm).replaceAll("[\\[\\],]", ""));
        } else {
            for (int i = 0; i < elements.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    perm[index] = elements[i];
                    gen(index + 1, elements, used, perm);
                    used[i] = false;
                }
            }
        }
    }
}
