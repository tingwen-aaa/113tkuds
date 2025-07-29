import java.util.*;

public class F04_TieredIncomeTax {
    static int[] bounds = {540000, 1210000, 2420000, 4530000};
    static double[] rates = {0.05, 0.12, 0.20, 0.30, 0.40};

    public static int calcTax(int income) {
        int tax = 0;
        int prev = 0;

        for (int i = 0; i < bounds.length; i++) {
            if (income > bounds[i]) {
                tax += (bounds[i] - prev) * rates[i];
                prev = bounds[i];
            } else {
                tax += (income - prev) * rates[i];
                return tax;
            }
        }

        tax += (income - bounds[bounds.length - 1]) * rates[rates.length - 1];
        return tax;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int total = 0;

        for (int i = 0; i < n; i++) {
            int income = Integer.parseInt(sc.nextLine());
            int tax = calcTax(income);
            System.out.println("Tax: $" + tax);
            total += tax;
        }

        double avg = (double) total / n;
        System.out.printf("Average: $%.2f\n", avg);
        sc.close();
    }
}
