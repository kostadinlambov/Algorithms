package combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P02_Combinations_without_Repetitions {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int numOfElements = Integer.parseInt(reader.readLine());

        String[] elements = new String[input.length];
        String[] variation = new String[numOfElements];;

        for (int i = 0; i < input.length; i++) {
            elements [i]= input[i];
        }


        gen(0, 0, elements, variation);
    }

    private static void gen(int index, int start, String[] elements, String[] variation) {
        if(index >= variation.length){
            System.out.println(Arrays.toString(variation).replaceAll("[\\[\\],]", ""));
        }
        else{
            for (int i = start; i < elements.length; i++) {
                    variation[index] = elements[i];
                    gen(index + 1, i + 1, elements, variation);
            }
        }
    }
}
