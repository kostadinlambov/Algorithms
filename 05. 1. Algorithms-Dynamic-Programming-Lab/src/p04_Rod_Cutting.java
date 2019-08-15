import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p04_Rod_Cutting {
    private static int[] prices;
    private static int[] bestPrice;
    private static int[] bestCombo;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        prices = Arrays.stream(reader.readLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        bestPrice = new int[prices.length];
        Arrays.fill(bestPrice, 0);

        bestCombo = new int[prices.length];

        int rodLength = Integer.parseInt(reader.readLine());

        System.out.println(cutRodIterative(rodLength));
        ReconstructionSolution(rodLength);
    }

    private static int cutRodIterative(int rodLength) {
        for (int i = 1; i <= rodLength; i++) {
            int currentBest = bestPrice[i];

            for (int j= 1; j <= i; j++) {

                currentBest = Math.max(bestPrice[i], prices[j] + bestPrice[i-j]);
               int currentBest2 = Math.max(1, 5 + 0);

                if (currentBest > bestPrice[i]) {
                    bestPrice[i] = currentBest;
                    bestCombo[i] = j;
                }
            }
        }
        return bestPrice[rodLength];
    }

    private static void ReconstructionSolution(int n){
        while(n - bestCombo[n] != 0){
            System.out.print(bestCombo[n] + " ");
            n = n -bestCombo[n];
        }

        System.out.println(bestCombo[n]);
    }


    private static int cutRod(int rodLength) {
        if (bestPrice[rodLength] >= 0) {
            return bestPrice[rodLength];
        }

        if (rodLength == 0) {
            return 0;
        }

        int currentBest = bestPrice[rodLength];

        for (int i = 1; i <= rodLength; i++) {
            currentBest = Math.max(currentBest, prices[i] + cutRod(rodLength - 1));

            if (currentBest > bestPrice[rodLength]) {
                bestPrice[rodLength] = currentBest;
                bestCombo[rodLength] = i;
            }
        }

        return bestPrice[rodLength];
    }


}
