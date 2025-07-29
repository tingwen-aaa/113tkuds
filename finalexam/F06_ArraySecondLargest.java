import java.util.*;

public class F06_ArraySecondLargest {
    static class Pair {
        int max, second;
        Pair(int max, int second) {
            this.max = max;
            this.second = second;
        }
    }

    public static Pair findSecondMax(int[] arr, int left, int right) {
        if (left == right) {
            return new Pair(arr[left], Integer.MIN_VALUE);
        }

        int mid = (left + right) / 2;
        Pair p1 = findSecondMax(arr, left, mid);
        Pair p2 = findSecondMax(arr, mid + 1, right);

        int max, second;
        if (p1.max > p2.max) {
            max = p1.max;
            second = Math.max(p1.second, p2.max < p1.max ? p2.max : Integer.MIN_VALUE);
        } else if (p2.max > p1.max) {
            max = p2.max;
            second = Math.max(p2.second, p1.max < p2.max ? p1.max : Integer.MIN_VALUE);
        } else {
            max = p1.max;
            second = Math.max(p1.second, p2.second);
        }

        return new Pair(max, second);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Pair result = findSecondMax(arr, 0, n - 1);
        System.out.println("SecondMax: " + result.second);
        sc.close();
    }
}
