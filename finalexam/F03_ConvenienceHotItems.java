import java.util.*;

public class F03_ConvenienceHotItems {
    static class Item {
        String name;
        int qty;

        Item(String name, int qty) {
            this.name = name;
            this.qty = qty;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Item> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String name = parts[0];
            int qty = Integer.parseInt(parts[1]);

            int pos = 0;
            while (pos < items.size() && items.get(pos).qty >= qty) {
                pos++;
            }
            items.add(pos, new Item(name, qty));
        }

        for (int i = 0; i < Math.min(10, items.size()); i++) {
            Item it = items.get(i);
            System.out.println(it.name + " " + it.qty);
        }

        sc.close();
    }
}
