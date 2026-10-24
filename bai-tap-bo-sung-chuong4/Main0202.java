import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class SanPham {
    private String maLoai;
    private String tenSP;
    private long donGia1;
    private long donGia2;

    public SanPham(String maLoai, String tenSP, long donGia1, long donGia2) {
        this.maLoai = maLoai;
        this.tenSP = tenSP;
        this.donGia1 = donGia1;
        this.donGia2 = donGia2;
    }

    public String getTenSP() {
        return tenSP;
    }

    public long getDonGia(int loai) {
        return (loai == 1) ? donGia1 : donGia2;
    }

    public String getMaLoai() {
        return maLoai;
    }
}

class HoaDon {
    private String maHD;
    private SanPham sp;
    private long giamGia;
    private long phaiTra;

    public HoaDon(int stt, String maBanDau, long soLuong, SanPham sp) {
        this.maHD = String.format("%s-%03d", maBanDau, stt);
        this.sp = sp;

        int loai = maBanDau.charAt(2) - '0';

        long donGia = sp.getDonGia(loai);
        long thanhTien = soLuong * donGia;

        int phanTramGiam = 0;
        if (soLuong >= 150) {
            phanTramGiam = 50;
        } else if (soLuong >= 100) {
            phanTramGiam = 30;
        } else if (soLuong >= 50) {
            phanTramGiam = 15;
        }

        this.giamGia = (thanhTien * phanTramGiam) / 100;
        this.phaiTra = thanhTien - this.giamGia;
    }

    @Override
    public String toString() {
        return maHD + " " + sp.getTenSP() + " " + giamGia + " " + phaiTra;
    }
}

public class Main0202 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        Map<String, SanPham> mapSanPham = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String maLoai = sc.nextLine().trim();
            String tenSP = sc.nextLine().trim();
            long gia1 = Long.parseLong(sc.nextLine().trim());
            long gia2 = Long.parseLong(sc.nextLine().trim());

            mapSanPham.put(maLoai, new SanPham(maLoai, tenSP, gia1, gia2));
        }

        int m = Integer.parseInt(sc.nextLine().trim());
        List<HoaDon> danhSachHD = new ArrayList<>();

        for (int i = 1; i <= m; i++) {
            String[] tokens = sc.nextLine().trim().split("\\s+");
            String maBanDau = tokens[0];
            long soLuong = Long.parseLong(tokens[1]);

            String maLoai = maBanDau.substring(0, 2);
            SanPham sp = mapSanPham.get(maLoai);

            danhSachHD.add(new HoaDon(i, maBanDau, soLuong, sp));
        }

        for (HoaDon hd : danhSachHD) {
            System.out.println(hd);
        }

        sc.close();
    }
}
