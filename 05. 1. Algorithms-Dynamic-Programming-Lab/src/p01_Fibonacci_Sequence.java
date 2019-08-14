import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p01_Fibonacci_Sequence {
    public static int memorizationArr[];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        memorizationArr = new int[n+1];
        System.out.println(fib(n));
    }

    private static int fib(int n) {
        if(memorizationArr[n] != 0){
            return memorizationArr[n];
        }

        if(n == 1 || n == 2){
            return 1;
        }

        int result =  fib(n-1) + fib(n-2);
        memorizationArr[n] = result;
        return result;
    }
}
