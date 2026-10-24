import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

class GiangVien {
    private String maGV;
    private String tenGV;
    private double tongGio;

    public GiangVien(String maGV, String tenGV) {
        this.maGV = maGV;
        this.tenGV = tenGV;
        this.tongGio = 0.0;
    }

    public void themGio(double gio) {
        this.tongGio += gio;
    }

    public String getTenGV() {
        return tenGV;
    }

    public double getTongGio() {
        return tongGio;
    }

    public String getMaGV() {
        return maGV;
    }

    @Override
    public String toString() {
        // Sử dụng Locale.US để đảm bảo dấu thập phân là dấu chấm (.) theo chuẩn hệ
        // thống PTIT
        return tenGV + " " + String.format(Locale.US, "%.2f", tongGio);
    }
}

public class Main0302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Đọc danh sách môn học (chỉ đọc lướt qua vì output không yêu cầu tên môn)
        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < n; i++) {
            sc.nextLine();
        }

        // 2. Đọc danh sách giảng viên
        int m = Integer.parseInt(sc.nextLine().trim());
        List<GiangVien> dsGV = new ArrayList<>();
        Map<String, GiangVien> mapGV = new HashMap<>();

        for (int i = 0; i < m; i++) {
            String line = sc.nextLine().trim();
            // Cắt chuỗi thành 2 phần: [Mã GV] và [Tên GV]
            String[] parts = line.split("\\s+", 2);
            String maGV = parts[0];
            String tenGV = parts[1];

            GiangVien gv = new GiangVien(maGV, tenGV);
            dsGV.add(gv); // Lưu vào List để giữ đúng thứ tự nhập ban đầu
            mapGV.put(maGV, gv); // Lưu vào Map để tìm kiếm nhanh khi tính giờ
        }

        // 3. Đọc danh sách giờ dạy và cộng dồn
        int k = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < k; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String maGV = parts[0];
            // parts[1] là mã môn, không cần dùng
            double gio = Double.parseDouble(parts[2]);

            // Tìm giảng viên tương ứng và cộng dồn giờ
            GiangVien gv = mapGV.get(maGV);
            if (gv != null) {
                gv.themGio(gio);
            }
        }

        // 4. In kết quả theo thứ tự ban đầu
        for (GiangVien gv : dsGV) {
            System.out.println(gv);
        }

        sc.close();
    }
}
