package midterm;

import java.util.*;

/*
 * Time Complexity: O(n)
 * 說明：轉換時間陣列與線性搜尋下一班皆為 O(n)，未使用二分搜尋。
 */

public class Q2_NextTHSRDeparture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] times = new int[n];
        String[] timeStrs = new String[n];

        for (int i = 0; i < n; i++) {
            timeStrs[i] = sc.nextLine();
            times[i] = toMinutes(timeStrs[i]);
        }

        String queryStr = sc.nextLine();
        int query = toMinutes(queryStr);

        int resultIdx = -1;
        for (int i = 0; i < n; i++) {
            if (times[i] > query) {
                resultIdx = i;
                break;
            }
        }

        if (resultIdx == -1) {
            System.out.println("No train");
        } else {
            System.out.println(timeStrs[resultIdx]);
        }
    }

    private static int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}