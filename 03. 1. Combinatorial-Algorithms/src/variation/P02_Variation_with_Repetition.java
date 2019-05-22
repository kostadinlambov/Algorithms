package variation;

import java.util.Arrays;

public class P02_Variation_with_Repetition {
    public static void main(String[] args) {
        int[] elements = new int[]{1, 2, 3};
        int[] variation = new int[2];

        gen(0, elements, variation);
    }

    private static void gen(int index, int[] elements, int[] variation) {

        if (index == variation.length) {
            System.out.println(Arrays.toString(variation).replaceAll("[\\[\\],]", ""));
        } else {
            for (int i = 0; i < elements.length; i++) {
                variation[index] = elements[i];
                gen(index + 1, elements, variation);
            }
        }
    }
}
