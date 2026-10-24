import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class NhanVien {
    private String maNV;
    private String hoTen;
    private String chucVu;
    private int luongCoBan;
    private int soNgayCong;

    public NhanVien(int stt, String hoTen, String chucVu, int luongCoBan, int soNgayCong) {
        // Mã nhân viên tự động sinh: NV01, NV02...
        this.maNV = String.format("NV%02d", stt);
        this.hoTen = hoTen;
        this.chucVu = chucVu;
        this.luongCoBan = luongCoBan;
        this.soNgayCong = soNgayCong;
    }

    public String getChucVu() {
        return chucVu;
    }

    // Tính phụ cấp theo chức vụ
    public int getPhuCap() {
        switch (chucVu) {
            case "GD":
                return 500;
            case "PGD":
                return 400;
            case "TP":
                return 300;
            case "KT":
                return 250;
            default:
                return 100;
        }
    }

    // Tính lương chính
    public int getLuongChinh() {
        return luongCoBan * soNgayCong;
    }

    // Tính tạm ứng (làm tròn đến hàng ngàn)
    public int getTamUng() {
        double mucTamUng = (getPhuCap() + getLuongChinh()) * 2.0 / 3.0;
        if (mucTamUng < 25000) {
            // Làm tròn đến hàng ngàn bằng cách chia 1000, dùng Math.round rồi nhân lại 1000
            return (int) Math.round(mucTamUng / 1000.0) * 1000;
        } else {
            return 25000;
        }
    }

    // Tính số tiền còn lại
    public int getConLai() {
        return getLuongChinh() + getPhuCap() - getTamUng();
    }

    @Override
    public String toString() {
        return maNV + " " + hoTen + " " + getPhuCap() + " " + getLuongChinh() + " " + getTamUng() + " " + getConLai();
    }
}

public class Main0102 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Đọc số lượng nhân viên
        int n = Integer.parseInt(sc.nextLine().trim());
        List<NhanVien> danhSachNV = new ArrayList<>();

        // Nhập thông tin từng nhân viên
        for (int i = 1; i <= n; i++) {
            String hoTen = sc.nextLine().trim();
            String chucVu = sc.nextLine().trim();
            int luongCoBan = Integer.parseInt(sc.nextLine().trim());
            int soNgayCong = Integer.parseInt(sc.nextLine().trim());

            danhSachNV.add(new NhanVien(i, hoTen, chucVu, luongCoBan, soNgayCong));
        }

        // Đọc chức vụ cần tìm kiếm ở dòng cuối cùng
        String chucVuCanTim = sc.nextLine().trim();

        // In ra những nhân viên có chức vụ khớp với từ khóa
        for (NhanVien nv : danhSachNV) {
            if (nv.getChucVu().equals(chucVuCanTim)) {
                System.out.println(nv);
            }
        }

        sc.close();
    }
}
