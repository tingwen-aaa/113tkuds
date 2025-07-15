package midterm;

import java.util.Scanner;

public class Q10_ArrayToStringUtil {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 讀取陣列大小 n
        int n = Integer.parseInt(sc.nextLine());

        // 如果 n 大於 0，讀取陣列的元素
        int[] arr = new int[n];
        if (n > 0) {
            String[] input = sc.nextLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }
        }

        // 輸出陣列的字串化結果
        System.out.println(arrayToString(arr));
    }

    public static String arrayToString(int[] arr) {
        if (arr == null) {
            return "null";
        }
        
        // 如果是空陣列，直接返回 []
        if (arr.length == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        // 遍歷陣列，將每個元素轉為字串並加到 StringBuilder 中
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }
}
