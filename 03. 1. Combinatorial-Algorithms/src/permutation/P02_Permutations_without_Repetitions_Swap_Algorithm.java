package permutation;

import java.util.Arrays;

public class P02_Permutations_without_Repetitions_Swap_Algorithm {
    private static int[] elements = new int[]{1, 2, 3};

    public static void main(String[] args) {
        gen(0);
    }

    private static void gen(int index) {
        if (index >= elements.length) {
            System.out.println(Arrays.toString(elements).replaceAll("[\\[\\],]", ""));
        } else {
            gen(index + 1);
            for (int i = index + 1; i < elements.length; i++) {
                swap(index, i);
                gen(index + 1);
                swap(index, i);
            }
        }
    }

    private static void swap(int index, int i) {
        int temp = elements[index];
        elements[index] = elements[i];
        elements[i] = temp;
    }
}
