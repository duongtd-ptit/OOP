import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SinhVien {
    private String maSV;
    private String hoTen;
    private String sdt;

    public SinhVien(String maSV, String hoTen, String sdt) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return maSV + " " + hoTen + " " + sdt;
    }
}

public class Main0502 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        List<List<SinhVien>> danhSachNhom = new ArrayList<>();
        for (int i = 0; i <= m; i++) {
            danhSachNhom.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            String maSV = sc.nextLine().trim();
            String hoTen = sc.nextLine().trim();
            String sdt = sc.nextLine().trim();
            int sttNhom = Integer.parseInt(sc.nextLine().trim());

            danhSachNhom.get(sttNhom).add(new SinhVien(maSV, hoTen, sdt));
        }

        String[] baiTap = new String[m + 1];
        for (int i = 1; i <= m; i++) {
            baiTap[i] = sc.nextLine().trim();
        }

        int q = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < q; i++) {
            int sttTruyVan = Integer.parseInt(sc.nextLine().trim());

            System.out.println("DANH SACH NHOM " + sttTruyVan + ":");

            for (SinhVien sv : danhSachNhom.get(sttTruyVan)) {
                System.out.println(sv);
            }

            System.out.println("Bai tap dang ky: " + baiTap[sttTruyVan]);
        }

        sc.close();
    }
}
