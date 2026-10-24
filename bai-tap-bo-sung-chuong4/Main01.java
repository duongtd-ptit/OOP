import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLong()) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            if (a <= 0 || b <= 0) {
                System.out.println(0);
            } else {
                long chuVi = (a + b) * 2;
                long dienTich = a * b;
                System.out.println(chuVi + " " + dienTich);
            }
        }
        sc.close();
    }
}
