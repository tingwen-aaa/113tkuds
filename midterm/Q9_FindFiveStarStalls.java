package midterm;

import java.util.ArrayList;
import java.util.Scanner;

public class Q9_FindFiveStarStalls {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 讀取攤位數量
        int n = Integer.parseInt(sc.nextLine());

        // 讀取所有攤位的評分
        String[] scores = sc.nextLine().split(" ");
        
        // 用 ArrayList 來儲存評分為 5 的攤位索引
        ArrayList<Integer> fiveStarIndices = new ArrayList<>();
        
        // 走訪所有評分，找出 5 分的攤位
        for (int i = 0; i < n; i++) {
            if (Double.parseDouble(scores[i]) == 5.0) {
                fiveStarIndices.add(i);
            }
        }

        // 如果找不到 5 分攤位，輸出 "None"
        if (fiveStarIndices.isEmpty()) {
            System.out.println("None");
        } else {
            // 輸出所有評分為 5 的攤位索引
            for (int idx : fiveStarIndices) {
                System.out.print(idx + " ");
            }
            System.out.println();
        }
    }
}

/*
 * Time Complexity: O(n)
 * 說明：程式遍歷所有攤位的評分一次，時間複雜度為 O(n)，其中 n 是攤位的數量。
 */
