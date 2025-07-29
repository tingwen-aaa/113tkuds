import java.util.*;

public class F02_YouBikeNextFull {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Integer> times = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String time = sc.nextLine();
            String[] parts = time.split(":");
            int minutes = Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
            times.add(minutes);
        }

        String query = sc.nextLine();
        String[] qParts = query.split(":");
        int qTime = Integer.parseInt(qParts[0]) * 60 + Integer.parseInt(qParts[1]);

        int result = -1;
        for (int t : times) {
            if (t >= qTime) {
                result = t;
                break;
            }
        }

        if (result == -1) {
            System.out.println("No bike");
        } else {
            int hour = result / 60;
            int minute = result % 60;
            System.out.printf("%02d:%02d\n", hour, minute);
        }

        sc.close();
    }
}
