package permutation;

import java.util.Arrays;

public class P03_Permutations_with_Repetitions_optimized {
    public static void main(String[] args) {
        int[] elements = new int[]{1, 2, 2, 3};
        int[] ints = Arrays.stream(elements).sorted().toArray();

        int start = 0;
        int end = ints.length - 1;
        permuteRep(ints, start, end);
    }

    private static void permuteRep(int[] ints, int start, int end) {
        System.out.println(Arrays.toString(ints).replaceAll("[\\[\\],]", ""));

        if (start < end) {
            for (int left = end - 2; left >= start; left--) {
                for (int right = left + 1; right < end; right++) {
                    if (ints[left] != ints[right]) {
                        swap(ints, left, right);
                        permuteRep(ints, left + 1, end);
                    }

                    int firstElement = ints[left];
                    for (int i = left; i < end - 1; i++) {
                        ints[i] = ints[i + 1];
                        ints[end - 1] = firstElement;
                    }
                }
            }
        }
    }

    private static void swap(int[] ints, int index, int i) {
        int temp = ints[index];
        ints[index] = ints[i];
        ints[i] = temp;
    }
}
