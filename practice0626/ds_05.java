package practice0626;

public class ds_05 {
    public static void main(String[] args) {
        int[] numbers = {3, 5, 8, 2, 7, 4, 6, 1, 9, 10};

        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        System.out.println("陣列的總和為：" + sum);
    }
}