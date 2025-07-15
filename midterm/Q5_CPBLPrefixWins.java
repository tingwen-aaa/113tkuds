package midterm;

import java.util.Scanner;

/*
 * Time Complexity: O(n)
 * 說明：前綴陣列建立為 O(n)，印出前 k 筆為 O(k)，總體仍為 O(n)。
 */

public class Q5_CPBLPrefixWins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        int[] ps = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ps[i] = ps[i - 1] + a[i - 1];
        }

        System.out.print("PrefixSum:");
        for (int i = 1; i <= k; i++) {
            System.out.print(" " + ps[i]);
        }
        System.out.println();
    }
}