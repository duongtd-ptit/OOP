import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class KhachHang {
    private String maKH;
    private String tenKH;
    private String gioiTinh;
    private String ngaySinh;
    private String diaChi;

    public KhachHang(int stt, String tenKH, String gioiTinh, String ngaySinh, String diaChi) {
        this.maKH = String.format("KH%03d", stt);
        this.tenKH = tenKH;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }

    public String getMaKH() {
        return maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }
}

class MatHang {
    private String maMH;
    private String tenMH;
    private String donViTinh;
    private long giaMua;
    private long giaBan;

    public MatHang(int stt, String tenMH, String donViTinh, long giaMua, long giaBan) {
        this.maMH = String.format("MH%03d", stt);
        this.tenMH = tenMH;
        this.donViTinh = donViTinh;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
    }

    public String getMaMH() {
        return maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public long getGiaMua() {
        return giaMua;
    }

    public long getGiaBan() {
        return giaBan;
    }
}

class HoaDon {
    private String maHD;
    private KhachHang kh;
    private MatHang mh;
    private long soLuong;

    public HoaDon(int stt, KhachHang kh, MatHang mh, long soLuong) {
        this.maHD = String.format("HD%03d", stt);
        this.kh = kh;
        this.mh = mh;
        this.soLuong = soLuong;
    }

    public long getThanhTien() {
        return soLuong * mh.getGiaBan();
    }

    @Override
    public String toString() {
        return maHD + " " + kh.getTenKH() + " " + kh.getDiaChi() + " " +
                mh.getTenMH() + " " + mh.getDonViTinh() + " " +
                mh.getGiaMua() + " " + mh.getGiaBan() + " " +
                soLuong + " " + getThanhTien();
    }
}

public class Main0402 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        Map<String, KhachHang> mapKH = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String ten = sc.nextLine().trim();
            String gt = sc.nextLine().trim();
            String ns = sc.nextLine().trim();
            String dc = sc.nextLine().trim();
            KhachHang kh = new KhachHang(i, ten, gt, ns, dc);
            mapKH.put(kh.getMaKH(), kh);
        }

        int m = Integer.parseInt(sc.nextLine().trim());
        Map<String, MatHang> mapMH = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            String ten = sc.nextLine().trim();
            String dvt = sc.nextLine().trim();
            long giaMua = Long.parseLong(sc.nextLine().trim());
            long giaBan = Long.parseLong(sc.nextLine().trim());
            MatHang mh = new MatHang(i, ten, dvt, giaMua, giaBan);
            mapMH.put(mh.getMaMH(), mh);
        }

        int k = Integer.parseInt(sc.nextLine().trim());
        for (int i = 1; i <= k; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String maKH = parts[0];
            String maMH = parts[1];
            long soLuong = Long.parseLong(parts[2]);

            KhachHang kh = mapKH.get(maKH);
            MatHang mh = mapMH.get(maMH);

            HoaDon hd = new HoaDon(i, kh, mh, soLuong);
            System.out.println(hd);
        }
        sc.close();
    }
}
