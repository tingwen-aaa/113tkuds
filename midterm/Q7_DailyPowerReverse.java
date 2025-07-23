package midterm;

import java.util.Scanner;

public class Q7_DailyPowerReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 讀取 7 個整數 (週一到週日的用電量)
        int[] power = new int[7];
        for (int i = 0; i < 7; i++) {
            power[i] = sc.nextInt();
        }

        // 反轉陣列，使用雙指標 (left, right)
        int left = 0, right = 6;
        while (left < right) {
            // 交換 power[left] 和 power[right]
            int temp = power[left];
            power[left] = power[right];
            power[right] = temp;

            // 移動指標
            left++;
            right--;
        }

        // 輸出反轉後的結果
        for (int i = 0; i < 7; i++) {
            System.out.print(power[i] + " ");
        }
    }
}
