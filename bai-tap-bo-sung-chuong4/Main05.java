import java.util.Scanner;

class Point {
    private double x;
    private double y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    public double distance(Point secondPoint) {
        return Math.sqrt(Math.pow(this.x - secondPoint.x, 2) + Math.pow(this.y - secondPoint.y, 2));
    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

public class Main05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                double x1 = sc.nextDouble();
                double y1 = sc.nextDouble();
                double x2 = sc.nextDouble();
                double y2 = sc.nextDouble();
                double x3 = sc.nextDouble();
                double y3 = sc.nextDouble();

                Point p1 = new Point(x1, y1);
                Point p2 = new Point(x2, y2);
                Point p3 = new Point(x3, y3);

                double a = p1.distance(p2);
                double b = p2.distance(p3);
                double c = p3.distance(p1);

                if (a + b > c && a + c > b && b + c > a) {
                    double perimeter = a + b + c;
                    System.out.printf("%.3f\n", perimeter);
                } else {
                    System.out.println("INVALID");
                }
            }
        }
        sc.close();
    }
}
