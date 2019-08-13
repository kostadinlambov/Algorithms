package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class p02_secCover_new {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] universe = Arrays.stream(reader.readLine()
                .substring(10)
                .split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int numberOfSets = Integer.parseInt(reader.readLine().substring(16));

        List<int[]> sets = new ArrayList<>();

        for (int i = 0; i < numberOfSets; i++) {
            int[] currentArr = Arrays.stream(reader.readLine()
                    .split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            sets.add(currentArr);

        }

        List<int[]> result = chooseSets(sets, universe);

        System.out.println();

        printSets(result);
    }

    public static List<int[]> chooseSets(List<int[]> sets, int[] universe) {
        List<int[]> result = new ArrayList<>();
        Set<Integer> universeSet = Arrays.stream(universe).boxed().collect(Collectors.toSet());

        List<int[]> sortedSets = sets.stream()
                .sorted((x, y) -> y.length - x.length)
                .collect(Collectors.toList());

        for (int i = 0; i < sortedSets.size(); i++) {

            int[] currentSet = sortedSets.get(i);

            boolean containsNumber = checkIfArrayContainsNumber(currentSet, universeSet);

            if (containsNumber) {
                result.add(currentSet);
                for (int j = 0; j < currentSet.length; j++) {
                    if (universeSet.contains(currentSet[j])) {
                        universeSet.remove(currentSet[j]);

                        if (universeSet.size() == 0) {
                            return result;
                        }
                    }
                }
            }
        }

        return result;
    }

    private static void printSets(List<int[]> result) {
        StringBuilder stringToPrint = new StringBuilder();
        stringToPrint.append(String.format("Sets to take (%d):", result.size()))
                .append(System.lineSeparator());

        for (int[] ints : result) {
            String currentArray = Arrays.toString(ints).replaceAll("[\\[\\]]", "");
            stringToPrint.append(String.format("{ %s }", currentArray))
                    .append(System.lineSeparator());
        }

        System.out.println(stringToPrint.toString().trim());
    }

    private static boolean checkIfArrayContainsNumber(int[] x, Set<Integer> universeSet) {
        for (int i : x) {
            if (universeSet.contains(i)) {
                return true;
            }
        }

        return false;
    }

}
