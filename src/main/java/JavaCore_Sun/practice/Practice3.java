package JavaCore_Sun.practice;// File: Practice3.java
import java.util.*;
import java.util.regex.*;

abstract class PhuongTien {
    protected String bienSo;
    protected String hangSanXuat;
    protected int namSanXuat;
    protected String mauXe;
    protected ChuSoHuu chuSoHuu;

    public PhuongTien(String bienSo, String hangSanXuat, int namSanXuat, String mauXe, ChuSoHuu chuSoHuu) {
        this.bienSo = bienSo;
        this.hangSanXuat = hangSanXuat;
        this.namSanXuat = namSanXuat;
        this.mauXe = mauXe;
        this.chuSoHuu = chuSoHuu;
    }

    public String layBienSo() {
        return bienSo;
    }

    public String layHangSanXuat() {
        return hangSanXuat;
    }

    public ChuSoHuu layChuSoHuu() {
        return chuSoHuu;
    }

    public abstract String layLoai();

    public void hienThi() {
        System.out.println("Bien so: " + bienSo);
        System.out.println("Hang san xuat: " + hangSanXuat);
        System.out.println("Nam san xuat: " + namSanXuat);
        System.out.println("Mau xe: " + mauXe);
        System.out.println("Chu so huu: " + chuSoHuu);
    }
}

class Oto extends PhuongTien {
    private int soCho;
    private String loaiDongCo;

    public Oto(String bienSo, String hangSanXuat, int namSanXuat, String mauXe, ChuSoHuu chuSoHuu, int soCho, String loaiDongCo) {
        super(bienSo, hangSanXuat, namSanXuat, mauXe, chuSoHuu);
        this.soCho = soCho;
        this.loaiDongCo = loaiDongCo;
    }

    @Override
    public String layLoai() {
        return "O to";
    }

    @Override
    public void hienThi() {
        super.hienThi();
        System.out.println("So cho: " + soCho);
        System.out.println("Loai dong co: " + loaiDongCo);
    }
}

class XeMay extends PhuongTien {
    private int dungTich;

    public XeMay(String bienSo, String hangSanXuat, int namSanXuat, String mauXe, ChuSoHuu chuSoHuu, int dungTich) {
        super(bienSo, hangSanXuat, namSanXuat, mauXe, chuSoHuu);
        this.dungTich = dungTich;
    }

    @Override
    public String layLoai() {
        return "Xe may";
    }

    @Override
    public void hienThi() {
        super.hienThi();
        System.out.println("Dung tich (cc): " + dungTich);
    }
}

class XeTai extends PhuongTien {
    private double taiTrong;

    public XeTai(String bienSo, String hangSanXuat, int namSanXuat, String mauXe, ChuSoHuu chuSoHuu, double taiTrong) {
        super(bienSo, hangSanXuat, namSanXuat, mauXe, chuSoHuu);
        this.taiTrong = taiTrong;
    }

    @Override
    public String layLoai() {
        return "Xe tai";
    }

    @Override
    public void hienThi() {
        super.hienThi();
        System.out.println("Tai trong (tan): " + taiTrong);
    }
}

class ChuSoHuu {
    private String cmnd;
    private String hoTen;
    private String email;

    public ChuSoHuu(String cmnd, String hoTen, String email) {
        this.cmnd = cmnd;
        this.hoTen = hoTen;
        this.email = email;
    }

    public String layCMND() {
        return cmnd;
    }

    public String toString() {
        return hoTen + " - " + cmnd + " - " + email;
    }
}

class QuanLyPhuongTien {
    private List<PhuongTien> danhSach = new ArrayList<>();

    public boolean kiemTraHopLe(String bienSo, String hang, int nam, String cmnd, String email) {
        if (bienSo.length() != 5) return false;
        if (!(hang.equals("Honda") || hang.equals("Yamaha") || hang.equals("Toyota") || hang.equals("Suzuki"))) return false;
        if (nam > Calendar.getInstance().get(Calendar.YEAR) || nam <= 2000) return false;
        if (!cmnd.matches("\\d{12}")) return false;
        if (!Pattern.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$", email)) return false;
        for (PhuongTien p : danhSach) if (p.layBienSo().equals(bienSo)) return false;
        return true;
    }

    public void them(PhuongTien p) {
        danhSach.add(p);
    }

    public void timTheoBienSo(String bienSo) {
        for (PhuongTien p : danhSach) {
            if (p.layBienSo().equalsIgnoreCase(bienSo)) {
                p.hienThi();
                return;
            }
        }
        System.out.println("Khong tim thay phuong tien voi bien so: " + bienSo);
    }

    public void timTheoCMND(String cmnd) {
        boolean timThay = false;
        for (PhuongTien p : danhSach) {
            if (p.layChuSoHuu().layCMND().equals(cmnd)) {
                p.hienThi();
                timThay = true;
            }
        }
        if (!timThay) System.out.println("Khong tim thay chu so huu co CMND: " + cmnd);
    }

    public void xoaTheoHang(String hang) {
        danhSach.removeIf(p -> p.layHangSanXuat().equalsIgnoreCase(hang));
        System.out.println("Da xoa toan bo xe cua hang: " + hang);
    }

    public void hangNhieuNhat() {
        Map<String, Integer> dem = new HashMap<>();
        for (PhuongTien p : danhSach) {
            dem.put(p.layHangSanXuat(), dem.getOrDefault(p.layHangSanXuat(), 0) + 1);
        }
        String hangMax = null;
        int max = 0;
        for (String key : dem.keySet()) {
            if (dem.get(key) > max) {
                max = dem.get(key);
                hangMax = key;
            }
        }
        System.out.println("Hang co nhieu xe nhat: " + hangMax + " voi " + max + " xe");
    }

    public void sapXepGiamDan() {
        Map<String, Long> tanSuat = new HashMap<>();
        for (PhuongTien p : danhSach) tanSuat.put(p.layHangSanXuat(), tanSuat.getOrDefault(p.layHangSanXuat(), 0L) + 1);
        danhSach.sort((p1, p2) -> Long.compare(tanSuat.get(p2.layHangSanXuat()), tanSuat.get(p1.layHangSanXuat())));
    }

    public void thongKeTheoLoai() {
        int oto = 0, xemay = 0, xetai = 0;
        for (PhuongTien p : danhSach) {
            switch (p.layLoai()) {
                case "O to": oto++; break;
                case "Xe may": xemay++; break;
                case "Xe tai": xetai++; break;
            }
        }
        System.out.println("O to: " + oto);
        System.out.println("Xe may: " + xemay);
        System.out.println("Xe tai: " + xetai);
    }

    public void hienThiTatCa() {
        for (PhuongTien p : danhSach) {
            System.out.println("-----------------");
            p.hienThi();
        }
    }
}

public class Practice3 {
    public static void main(String[] args) {
        QuanLyPhuongTien ql = new QuanLyPhuongTien();

        ChuSoHuu c1 = new ChuSoHuu("123456789012", "Nguyen Van A", "a@gmail.com");
        ChuSoHuu c2 = new ChuSoHuu("987654321098", "Tran Thi B", "b@yahoo.com");

        if (ql.kiemTraHopLe("A1234", "Honda", 2022, c1.layCMND(), "a@gmail.com"))
            ql.them(new Oto("A1234", "Honda", 2022, "Do", c1, 5, "Xang"));

        if (ql.kiemTraHopLe("B5678", "Yamaha", 2023, c2.layCMND(), "b@yahoo.com"))
            ql.them(new XeMay("B5678", "Yamaha", 2023, "Xanh", c2, 150));

        if (ql.kiemTraHopLe("C9012", "Toyota", 2021, c1.layCMND(), "a@gmail.com"))
            ql.them(new XeTai("C9012", "Toyota", 2021, "Trang", c1, 3.5));

        System.out.println("== Danh sach phuong tien ==");
        ql.hienThiTatCa();

        System.out.println("\n== Tim theo bien so A1234 ==");
        ql.timTheoBienSo("A1234");

        System.out.println("\n== Tim theo CMND 123456789012 ==");
        ql.timTheoCMND("123456789012");

        System.out.println("\n== Thong ke theo loai ==");
        ql.thongKeTheoLoai();

        System.out.println("\n== Hang nhieu xe nhat ==");
        ql.hangNhieuNhat();
    }
}