public class P02_Longest_Common_Subsequence {

    public static void main(String[] args) {
        System.out.println(lcs("abcdef", "abc"));
        System.out.println(lcs("abcdef", "acf"));
        System.out.println(lcs("132535365", "123456789"));
    }

    public static String lcs(String x, String y) {
        StringBuilder resultSb = new StringBuilder();
        char[] first = x.toCharArray();
        char[] second = y.toCharArray();

        int[][] lcsMatr = new int[first.length + 1][second.length + 1];

        for (int row = 1; row <= first.length; row++) {
            for (int col = 1; col <= second.length; col++) {

                int up = lcsMatr[row - 1][col];
                int left = lcsMatr[row][col - 1];

                int result = Math.max(up, left);

                if (first[row - 1] == second[col - 1]) {
                    result = Math.max(1 + lcsMatr[row - 1][col - 1], result);
                }

                lcsMatr[row][col] = result;
            }
        }

        System.out.println(lcsMatr[first.length][second.length]);

        int currentRow = first.length;
        int currentCol = second.length;

        while (currentRow > 0 && currentCol > 0) {
            if (first[currentRow - 1] == second[currentCol - 1]
            && lcsMatr[currentRow][currentCol]- 1 == lcsMatr[currentRow-1][ currentCol - 1]) {
                System.out.print(first[currentRow - 1]);
                resultSb.append(first[currentRow - 1]);
                currentRow--;
                currentCol--;
            } else if (lcsMatr[currentRow - 1][currentCol] == lcsMatr[currentRow][currentCol]) {
                currentRow--;
            }else{
                currentCol--;
            }
        }

        return resultSb.reverse().toString();
    }
}
