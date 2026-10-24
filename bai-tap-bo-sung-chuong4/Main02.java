import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                long n = sc.nextLong();
                long s = n * (n + 1) / 2;
                System.out.println(s);
            }
        }
        sc.close();
    }
}
