package combination;

import java.util.Arrays;

public class P02_Combinations_without_Repetitions {
    private static int[] elements = new int[]{1, 2, 3};
    private static int[] variation  = new int[2];

    public static void main(String[] args) {
        gen(0, 0);
    }

    private static void gen(int index, int start) {
        if(index >= variation.length){
            System.out.println(Arrays.toString(variation).replaceAll("[\\[\\],]", ""));
        }
        else{
            for (int i = start; i < elements.length; i++) {
                    variation[index] = elements[i];
                    gen(index + 1, i + 1);
            }
        }
    }
}
