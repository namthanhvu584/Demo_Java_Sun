// 📁 Slide6 - Tổng hợp bài tập áp dụng cho: Collection, Generics, PECS, Lambda, Predicate

package JavaCore_Sun.Slide6;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        // So sánh Array vs Collection
        int[] mangSo = {1, 2, 3}; // Cố định 3 phần tử
        List<Integer> danhSachSo = new ArrayList<>(); // Co giãn động
        danhSachSo.add(1);
        danhSachSo.add(2);
        danhSachSo.add(3);

        //Duyệt mảng
        for (int so : mangSo) {
            System.out.println("[Array] So = " + so);
        }

        //Duyệt List
        for (int so : danhSachSo) {
            System.out.println("[List] So = " + so);
        }

        //  Các method cơ bản trong Collection
        danhSachSo.remove(Integer.valueOf(2)); // Xóa phần tử 2
        System.out.println("Sau khi xóa 2: " + danhSachSo);
        System.out.println("Có chứa 3 không? " + danhSachSo.contains(3));

        //  Generics: dùng class tổng quát
        Box<String> hopChu = new Box<>();
        hopChu.setGiaTri("Xin chao");
        System.out.println("Hộp chứa: " + hopChu.getGiaTri());

        Box<Integer> hopSo = new Box<>();
        hopSo.setGiaTri(100);
        System.out.println("Hộp chứa số: " + hopSo.getGiaTri());

        //  PECS: Producer extends, Consumer super
        List<? extends Number> danhSachDoc = List.of(1, 2, 3); // Chỉ đọc
        // danhSachDoc.add(4); // ❌ Không cho phép thêm

        List<? super Integer> danhSachGhi = new ArrayList<>();
        danhSachGhi.add(10); // ✅ Cho phép ghi Integer hoặc con của nó
        danhSachGhi.add(20);
        System.out.println("Danh sách Ghi: " + danhSachGhi);

        //  Raw type - KHÔNG NÊN DÙNG
        List rawList = new ArrayList();
        rawList.add("hello");
        rawList.add(123); // Không an toàn, dễ lỗi
        System.out.println("Raw List: " + rawList);

        //  Dữ liệu nguyên thủy và wrapper
        int a = 5;                    // Kiểu nguyên thủy
        Integer b = Integer.valueOf(a); // Wrapper class
        List<Integer> danhSachNguyen = List.of(a, b);
        System.out.println("Danh sách nguyên thủy: " + danhSachNguyen);

        //  Lambda expression
        List<String> ten = List.of("Nam", "An", "Nguyen");
        ten.forEach(t -> System.out.println("Xin chào, " + t)); // Duyệt bằng lambda

        //  Predicate interface
        Predicate<String> daiHon3 = s -> s.length() > 3; // biểu thức kiểm tra chuỗi dài hơn 3 ký tự
        System.out.println("Nguyen dài > 3? " + daiHon3.test("Nguyen"));
        System.out.println("An dài > 3? " + daiHon3.test("An"));

        // Kết hợp với Stream API để lọc tên dài
        ten.stream().filter(daiHon3).forEach(s -> System.out.println("Tên dài: " + s));
    }
}

// Lớp Generic Box<T>
class Box<T> {
    private T giaTri;

    public void setGiaTri(T giaTri) {
        this.giaTri = giaTri;
    }

    public T getGiaTri() {
        return giaTri;
    }
} //  Dùng được với nhiều kiểu khác nhau nhờ Generics
