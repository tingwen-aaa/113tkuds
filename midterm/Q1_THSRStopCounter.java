package midterm;

import java.util.Scanner;

/*
 * Time Complexity: O(n)
 * 說明：必須遍歷一次站名陣列，找到 startIdx 和 endIdx。最壞情況需要遍歷全部站數，時間複雜度為 O(n)。
 */

public class Q1_THSRStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();  // 站數
        String[] stations = new String[n];
        
        for (int i = 0; i < n; i++) {
            stations[i] = sc.next();  // 站名
        }
        
        String start = sc.next();  // 起點
        String end = sc.next();    // 終點
        
        int startIdx = -1, endIdx = -1;
        
        for (int i = 0; i < n; i++) {
            if (stations[i].equals(start)) startIdx = i;
            if (stations[i].equals(end)) endIdx = i;
        }
        
        if (startIdx == -1 || endIdx == -1) {
            System.out.println("Invalid");
        } else {
            System.out.println(Math.abs(startIdx - endIdx) + 1);
        }
        
        sc.close();
    }
}