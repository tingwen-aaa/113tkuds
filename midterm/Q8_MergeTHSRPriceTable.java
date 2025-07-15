package midterm;

import java.util.Scanner;

public class Q8_MergeTHSRPriceTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 讀取票價資料行數
        int n = Integer.parseInt(sc.nextLine());
        
        // 設定站名與票價表格
        String[] stations = new String[n];
        int[][] prices = new int[n][2];

        // 讀取每一行站名與票價資料
        for (int i = 0; i < n; i++) {
            stations[i] = sc.next();
            prices[i][0] = sc.nextInt();  // 標準票價
            prices[i][1] = sc.nextInt();  // 商務票價
        }

        // 輸出合併表格
        System.out.printf("%-10s%-10s%-10s\n", "Station", "Standard", "Business");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-10s%-10d%-10d\n", stations[i], prices[i][0], prices[i][1]);
        }
    }
}
