import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class p01_sumOfCoins_second_solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String coinsString = reader.readLine().split(": ")[1];
        int[] ints = Arrays.stream(coinsString.split(", "))
                .mapToInt(Integer::parseInt).toArray();

        int targetSum = Integer.parseInt(reader.readLine().split(": ")[1]);
//        int[] ints = new int[]{1000, 200, 30, 4};
//        int targetSum = 1234;

        int[] coins = Arrays.stream(ints).sorted().toArray();

        Map<Integer, Integer> coinsMap = chooseCoins(coins, targetSum);

        printResult(coinsMap);
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int sum) {
        int currentSum = 0;
        Map<Integer, Integer> coinsMap = new LinkedHashMap<>();

        for (int i = coins.length - 1; i >= 0; i--) {
            int currentCoin = coins[i];
            while (currentSum + currentCoin <= sum) {
                currentSum += currentCoin;
                if (!coinsMap.containsKey(currentCoin)) {
                    coinsMap.put(currentCoin, 0);
                }

                coinsMap.put(currentCoin, coinsMap.get(currentCoin) + 1);
            }
        }

        if (currentSum < sum) {
            throw new IllegalArgumentException();
        }

        return coinsMap;
    }

    private static void printResult(Map<Integer, Integer> coinsMap) {
        StringBuilder sb = new StringBuilder();
        int numberOfCoins = coinsMap.values().stream().mapToInt(x -> x).sum();

        sb.append(String.format("Number of coins to take: %d", numberOfCoins))
                .append(System.lineSeparator());
        for (Map.Entry<Integer, Integer> currentCoin : coinsMap.entrySet()) {
            sb.append(String.format("%d coin(s) with value %d", currentCoin.getValue(), currentCoin.getKey()))
                    .append(System.lineSeparator());
            ;
        }

        System.out.println(sb.toString().trim());
    }
}
