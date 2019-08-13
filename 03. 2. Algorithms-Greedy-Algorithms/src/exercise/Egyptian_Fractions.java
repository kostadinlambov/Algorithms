package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Egyptian_Fractions {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        List<Long> numbers = new ArrayList<>();

        String[] fraction = reader.readLine().split("/");

        long numerator = Long.parseLong(fraction[0]);
        long denominator = Long.parseLong(fraction[1]);

        if (numerator > denominator) {
            System.out.println("Error (fraction is equal to or greater than 1)");
            return;
        }

        result.append(String.format("%d/%d = ", numerator, denominator));

        long index = 2;

        while (numerator != 0) {

            long nextNumerator = numerator * index;
            long indexNumerator = denominator;

            long remainNum = nextNumerator - indexNumerator;

            if (remainNum < 0) {
                index++;
                continue;
            }

            numbers.add(index);

            numerator = remainNum;
            denominator = denominator * index;
            index++;
        }

        for (Long number : numbers) {
            result.append(String.format("1/%d + ",  number));
        }

        result.setLength(result.length() - 3);
        System.out.println(result.toString());
    }
}
