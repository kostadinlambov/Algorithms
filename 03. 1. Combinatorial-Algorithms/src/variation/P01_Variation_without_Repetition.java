package variation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P01_Variation_without_Repetition {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int variationCount = Integer.parseInt(reader.readLine());

        String[] elements = new String[input.length];
        String[] variation = new String[variationCount];
        boolean[] used = new boolean[input.length];

        for (int i = 0; i < input.length; i++) {
            elements [i]= input[i];
        }

        gen(0, elements, variation, used);
    }

    private static void gen(int index, String[] elements, String[] variation, boolean[] used) {

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
