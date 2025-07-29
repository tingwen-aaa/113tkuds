import java.util.*;

public class F08_ClimbStairsMemo {
    static int[] memo = new int[41];

    public static int countWays(int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        if (memo[n] != 0) return memo[n];
        memo[n] = countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
        return memo[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = countWays(n);
        System.out.println("Ways: " + w);
        sc.close();
    }
}
