package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02_Recursive_Factorial {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)));
        int number = Integer.parseInt(reader.readLine());

        int result = factorial(number);
        System.out.println(result);
    }

    private static int factorial(int number) {

        if(number == 0){
            return 1;
        }

        return number*factorial(number-1);
    }
}
