package combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P03_Combinations_count {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int elementsCount = Integer.parseInt(reader.readLine());
        int slotsCount = Integer.parseInt(reader.readLine());

        BigInteger binom = binom(elementsCount, slotsCount);
        System.out.println(binom);
    }

    private static BigInteger binom(int elementsCount, int slotsCount) {
        if(slotsCount > elementsCount){
            return BigInteger.ZERO;
        }
        if(slotsCount == 0 || slotsCount == elementsCount ){
            return BigInteger.ONE;
        }

        return binom(elementsCount-1, slotsCount - 1)
                .add(binom(elementsCount-1 , slotsCount));
    }

}
