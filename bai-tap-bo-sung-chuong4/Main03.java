import java.util.Scanner;

public class Main03 {
    static int n, k;
    static int[] x;
    static int count;

    public static void generate(int i, int start) {
        for (int j = start; j <= n - k + i; j++) {
            x[i] = j;
            if (i == k) {
                count++;
                for (int l = 1; l <= k; l++) {
                    System.out.print(x[l] + (l == k ? "" : " "));
                }
                System.out.println();
            } else {
                generate(i + 1, j + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            n = sc.nextInt();
            k = sc.nextInt();
            x = new int[k + 1];
            count = 0;
            generate(1, 1);
            System.out.println("Tong cong co " + count + " to hop");
        }
        sc.close();
    }
}
