import java.util.*;

public class Main04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            for (int tc = 1; tc <= t; tc++) {
                int n = sc.nextInt();
                int[] a = new int[n];
                Map<Integer, Integer> countMap = new LinkedHashMap<>();
                for (int i = 0; i < n; i++) {
                    a[i] = sc.nextInt();
                    countMap.put(a[i], countMap.getOrDefault(a[i], 0) + 1);
                }
                System.out.println("Test " + tc + ":");
                for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                    System.out.println(entry.getKey() + " xuat hien " + entry.getValue() + " lan");
                }
            }
        }
        sc.close();
    }
}
