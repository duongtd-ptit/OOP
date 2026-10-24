import java.util.ArrayList;

// BÀI 1 & BÀI 2: Quản lý điểm & Sinh mã số tự động
class Student {
    private static int counter = 0;

    private String mssv;
    private String name;
    private double diemCC;
    private double diemGK;
    private double diemCK;
    private String email;
    private String sdt;
    
    public Student(String name, double diemCC, double diemGK, double diemCK) {
        counter++;
        this.mssv = String.format("B25DCCC%03d", counter);
        this.name = name;
        setDiemCC(diemCC);
        setDiemGK(diemGK);
        setDiemCK(diemCK);
    }
    public String getMssv() {
        return mssv;
    }
    public String getName() {
        return name;
    }
    public double getDiemCC() {
        return diemCC;
    }
    public double getDiemGK() {
        return diemGK;
    }
    public double getDiemCK() {
        return diemCK;
    }
    public String getEmail() {
        return email;
    }
    public String getSdt() {
        return sdt;
    }
    public void setDiemCC(double diemCC) {
        if (diemCC >= 0 && diemCC <= 10)
            this.diemCC = diemCC;
    }
    public void setDiemGK(double diemGK) {
        if (diemGK >= 0 && diemGK <= 10)
            this.diemGK = diemGK;
    }
    public void setDiemCK(double diemCK) {
        if (diemCK >= 0 && diemCK <= 10)
            this.diemCK = diemCK;
    }
    public double diemTrungBinh() {
        return this.diemCC * 0.1 + this.diemGK * 0.3 + this.diemCK * 0.6;
    }
    public Student capNhatEmail(String email) {
        this.email = email;
        return this;
    }
    public Student capNhatSdt(String sdt) {
        this.sdt = sdt;
        return this;
    }
    public static int getTotalStudents() {
        return counter;
    }
}

// BÀI 3: Quản lý cả lớp & Xếp loại học lực
class Classroom {
    private String tenLop;
    private ArrayList<Student> danhSachSinhVien;
    public Classroom(String tenLop) {
        this.tenLop = tenLop;
        this.danhSachSinhVien = new ArrayList<>();
    }
    public void addStudent(Student s) {
        for (Student st : danhSachSinhVien) {
            if (st.getMssv().equals(s.getMssv())) {
                throw new IllegalArgumentException("Sinh viên có MSSV " + s.getMssv() + " đã tồn tại trong lớp.");
            }
        }
        danhSachSinhVien.add(s);
    }
    public String xepLoai(Student s) {
        double dtb = s.diemTrungBinh();
        if (dtb >= 8)
            return "Giỏi";
        if (dtb >= 6.5)
            return "Khá";
        if (dtb >= 5)
            return "Trung bình";
        return "Yếu";
    }
    public void inBangDiem() {
        System.out.println("--- BẢNG ĐIỂM LỚP " + tenLop + " ---");
        for (Student s : danhSachSinhVien) {
            System.out.printf("MSSV: %s | Tên: %s | ĐTB: %.2f | Xếp loại: %s\n",
                    s.getMssv(), s.getName(), s.diemTrungBinh(), xepLoai(s));
        }
        System.out.println("Sĩ số lớp: " + danhSachSinhVien.size());
    }
}
// Hàm Main thực thi
public class Main {
    public static void main(String[] args) {
        System.out.println("--- TEST BÀI 1 & BÀI 2 ---");
        Student sv1 = new Student("Trần Đăng Dương", 8, 7.5, 9);
        Student sv2 = new Student("Hoa", 9, 8, 8.5);
        Student sv3 = new Student("Minh", 5, 4, 6);
        // Gọi hàm liên tiếp trên 1 dòng
        sv1.capNhatEmail("duongtd@ptit.edu.vn").capNhatSdt("0912345678");
        System.out.println("MSSV sv1: " + sv1.getMssv() + " | Email: " + sv1.getEmail());
        System.out.println("Tổng sinh viên tạo ra: " + Student.getTotalStudents());
        // Thử gọi điểm không hợp lệ
        sv1.setDiemGK(-1);
        System.out.println("Điểm giữa kỳ sv1 sau khi set -1 (không bị đổi): " + sv1.getDiemGK());
        System.out.println("\n--- TEST BÀI 3 ---");
        Classroom classroom = new Classroom("D25CQCN");
        classroom.addStudent(sv1);
        classroom.addStudent(sv2);
        classroom.addStudent(sv3);
        //Thử thêm trùng lắp sinh viên 1
        try {
            System.out.println("Cố gắng thêm sinh viên sv1 một lần nữa...");
            classroom.addStudent(sv1);
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi bị chặn: " + e.getMessage());
        }

        System.out.println("\nChương trình vẫn tiếp tục chạy, in bảng điểm...");
        classroom.inBangDiem();
    }
}

