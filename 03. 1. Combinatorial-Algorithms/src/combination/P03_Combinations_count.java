package combination;

import java.math.BigInteger;

public class P03_Combinations_count {
    public static void main(String[] args) {
        BigInteger binom = binom(25, 10);
        System.out.println(binom);
    }

    private static BigInteger binom(int elementsCount, int slotsCount) {
        if(slotsCount > elementsCount){
            return BigInteger.ZERO;
        }
        if(slotsCount == 0 || slotsCount == elementsCount ){
            return BigInteger.ONE;
        }

        return binom(elementsCount-1, slotsCount - 1).add(binom(elementsCount-1 , slotsCount));
    }
}
