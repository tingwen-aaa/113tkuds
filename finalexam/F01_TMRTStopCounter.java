import java.util.*;

public class F01_TMRTStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if (n < 1 || n >= 131) {
            System.out.println("Invalid");
            return;
        }

        List<String> stations = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            stations.add(sc.next());
        }

        String start = sc.next();
        String end = sc.next();

        int indexStart = stations.indexOf(start);
        int indexEnd = stations.indexOf(end);

        if (indexStart == -1 || indexEnd == -1) {
            System.out.println("Invalid");
        } else {
            int stopCount = Math.abs(indexStart - indexEnd) + 1;
            System.out.println(stopCount);
        }

        sc.close();
    }
}
