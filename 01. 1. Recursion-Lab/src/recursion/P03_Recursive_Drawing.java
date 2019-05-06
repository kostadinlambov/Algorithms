package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class P03_Recursive_Drawing {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)));
        int number = Integer.parseInt(reader.readLine());
        draw(number);
    }

    private static void draw(int number) {

        if (number == 0) {
            return;
        }

        System.out.println(String.join("", Collections.nCopies(number, "*")));
        draw(number - 1);
        System.out.println(String.join("", Collections.nCopies(number, "#")));
    }
}
