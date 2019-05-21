package permutation;

import java.util.Arrays;
import java.util.HashSet;

public class P03_Permutations_with_Repetitions {
    private static int[] elements = new int[]{1, 2, 2, 3};

    public static void main(String[] args) {
        gen(0);
    }

    private static void gen(int index) {
        if (index >= elements.length) {
            System.out.println(Arrays.toString(elements).replaceAll("[\\[\\],]", ""));
        } else {
            HashSet<Integer> swapped = new HashSet<>();
            for (int i = index ; i < elements.length; i++) {
                if(!swapped.contains(elements[i])){
                    swap(index, i);
                    gen(index + 1);
                    swap(index, i);
                    swapped.add(elements[i]);
                }
            }
        }
    }

    private static void swap(int index, int i) {
        int temp = elements[index];
        elements[index] = elements[i];
        elements[i] = temp;
    }
}
