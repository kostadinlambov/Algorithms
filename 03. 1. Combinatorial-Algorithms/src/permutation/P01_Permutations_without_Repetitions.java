package permutation;

import java.util.Arrays;

public class P01_Permutations_without_Repetitions {
    private static int[] elements = new int[]{1, 2, 3};
    private static boolean[] used = new boolean[elements.length];
    private static int[] perm = new int[elements.length];

    public static void main(String[] args) {
        gen(0);
    }

    private static void gen(int index){
        if(index >= elements.length){
            System.out.println(Arrays.toString(perm).replaceAll("[\\[\\],]", ""));
        }else{
            for (int i = 0; i < elements.length; i++) {
               if(!used[i]){
                   used[i] = true;
                   perm[index] = elements[i];
                   gen(index + 1);
                   used[i] = false;
               }
            }
        }
    }
}
