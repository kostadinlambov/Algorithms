package variation;
import java.util.Arrays;

public class P01_Variation_without_Repetition {
    public static void main(String[] args) {
        int[] elements = new int[]{1, 2, 3};
        int[] variation  = new int[3];
        boolean[] used = new boolean[elements.length];

        gen(0, elements, variation, used);
    }

    private static void gen(int index, int[] elements, int[] variation, boolean[] used) {

        if(index == variation.length){
            System.out.println(Arrays.toString(variation).replaceAll("[\\[\\],]", ""));
        }
        else{
            for (int i = 0; i < elements.length; i++) {
                if(!used[i]){
                    used[i] = true;
                    variation[index] = elements[i];
                    gen(index + 1, elements, variation, used);
                    used[i] = false;
                }
            }
        }
    }
}
