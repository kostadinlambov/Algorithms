import java.util.*;
import java.util.stream.Collectors;

public class p02_setCover {

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
                set[j] = Integer.parseInt(setElements[j]);
            }

            sets.add(set);
        }

        List<int[]> choosenSets = chooseSets(sets, universe);
        System.out.printf("Sets to take (%d):\n", choosenSets.size());
        for (int[] choosenSet : choosenSets) {
            System.out.println(Arrays.toString(choosenSet));
        }
    }

    public static List<int[]> chooseSets(List<int[]> sets, int[] universe) {

        List<int[]> result = new ArrayList<>();

        Set<Integer> universeSet = Arrays.stream(universe)
                .boxed()
                .collect(Collectors.toSet());

        Set<int[]> setSet = new HashSet<>(sets);

        while(universeSet.size() > 0){
            int[] currentSet = setSet.stream()
                    .filter(x -> checkIfArrayContainsNumber(x, universeSet))
                    .max(Comparator.comparingInt(x -> x.length))
                    .get();

            result.add(currentSet);

            for (int number : currentSet) {
                universeSet.remove(number);
            }

        }
        return result;
    }

    private static boolean checkIfArrayContainsNumber(int[] x, Set<Integer> universeSet) {
        for (int i : x) {
            if(universeSet.contains(i)){
                return true;
            }
        }

        return false;
    }

}
