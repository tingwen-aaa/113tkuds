package midterm;
    
import java.util.Scanner;

/*
 * Time Complexity: O(n)
 * 說明：每筆電量計算費用為 O(1)，總共處理 n 筆資料。
 */

public class Q4_TieredElectricBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] bills = new int[n];

        int total = 0;
        for (int i = 0; i < n; i++) {
            int kWh = Integer.parseInt(sc.nextLine());
            bills[i] = calc(kWh);
            total += bills[i];
        }

        for (int b : bills) {
            System.out.println("Bill: $" + b);
        }

        int average = Math.round((float) total / n);
        System.out.println("Total: $" + total);
        System.out.println("Average: $" + average);
    }

    static int calc(int kWh) {
        int sum = 0;
        int[] limits = {120, 330, 500, 700, 1000};
        double[] rates = {1.68, 2.45, 3.70, 5.04, 6.24, 8.46};
        int[] ranges = new int[6];

        if (kWh <= 120) ranges[0] = kWh;
        else {
            ranges[0] = 120;
            if (kWh <= 330) ranges[1] = kWh - 120;
            else {
                ranges[1] = 210;
                if (kWh <= 500) ranges[2] = kWh - 330;
                else {
                    ranges[2] = 170;
                    if (kWh <= 700) ranges[3] = kWh - 500;
                    else {
                        ranges[3] = 200;
                        if (kWh <= 1000) ranges[4] = kWh - 700;
                        else {
                            ranges[4] = 300;
                            ranges[5] = kWh - 1000;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 6; i++) {
            sum += Math.round(ranges[i] * rates[i]);
        }

        return sum;
    }
}