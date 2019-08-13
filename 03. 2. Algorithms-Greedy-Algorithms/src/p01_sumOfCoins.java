import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p01_sumOfCoins {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] elements = in.nextLine().substring(7).split(", ");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(in.nextLine().substring(5));

//        int[] coins = new int[]{1, 2, 5, 10, 20, 50};
//        int targetSum = 923;

        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);
        printResult(usedCoins);
    }

    private static void printResult(Map<Integer, Integer> usedCoins) {
        int numberOfCoins = usedCoins.values().stream().mapToInt(Integer::valueOf).sum();
        System.out.println(String.format("Number of coins to take: %d", numberOfCoins));

        for (Map.Entry<Integer, Integer> currentEntry : usedCoins.entrySet()) {
            System.out.println(String.format("%d coin(s) with value %d", currentEntry.getValue(), currentEntry.getKey()));
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        int currentSum = 0;
        int coinIndex = coins.length - 1;

        int[] coinsSorted = Arrays.stream(coins).sorted().toArray();

        Map<Integer, Integer> result = new LinkedHashMap<>();

        while (targetSum > 0 && targetSum > currentSum && coinIndex >= 0 ) {

            if (currentSum + coinsSorted[coinIndex] > targetSum) {
                coinIndex--;
                continue;
            }

            currentSum += coinsSorted[coinIndex];

            if (!result.containsKey(coinsSorted[coinIndex])) {
                result.put(coinsSorted[coinIndex], 0);
            }

            result.put(coinsSorted[coinIndex], result.get(coinsSorted[coinIndex]) + 1);
        }

        if(targetSum != currentSum){
            throw  new IllegalArgumentException("Error");
        }else{
            return result;
        }
    }
}
