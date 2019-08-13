package lab;

import java.util.*;
import java.util.stream.Collectors;

public class p02_secCover {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] elements = in.nextLine().substring(10).split(", ");
        int[] universe = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            universe[i] = Integer.parseInt(elements[i]);
        }

        int numberOfSets = Integer.parseInt(in.nextLine().substring(16));
        List<int[]> sets = new ArrayList<>();
        for (int i = 0; i < numberOfSets; i++) {
            String[] setElements = in.nextLine().split(", ");
            int[] set = new int[setElements.length];
            for (int j = 0; j < setElements.length; j++) {
                set[i] = Integer.parseInt(setElements[i]);
            }
        }

        List<int[]> choosenSets = chooseSets(sets, universe);

        printSets(choosenSets);
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
