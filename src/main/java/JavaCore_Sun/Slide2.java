package JavaCore_Sun;

import java.util.Scanner;

public class Slide2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. PHÉP TOÁN TỪ CƠ BẢN
        int a = 10, b = 3;
        System.out.println("Cộng: " + (a + b));       // 13
        System.out.println("Trừ: " + (a - b));         // 7
        System.out.println("Nhân: " + (a * b));        // 30
        System.out.println("Chia: " + (a / b));        // 3
        System.out.println("Chia dư: " + (a % b));     // 1

        // 2. TOÁN TỬ SO SÁNH & LOGIC
        System.out.println("a > b: " + (a > b));       // true
        System.out.println("a == b: " + (a == b));     // false
        System.out.println("a != b: " + (a != b));     // true

        boolean x = true, y = false;
        System.out.println("x && y: " + (x && y));     // false
        System.out.println("x || y: " + (x || y));     // true
        System.out.println("!x: " + (!x));             // false

        //3. So sanh chuoi
        String s1 = "hi nam";
        String s2 = "hi nam";
        String s3 = new String("hi nam");
        System.out.println("s1 = s2: " + (s1 == s2));    //true
        System.out.println("s1 = s3: " + (s1 == s3));    //false
        System.out.println("s1.equals(s3): " + s1.equals(s3));   //true

        // 4. CÂU LỆNH IF ELSE
        double gpa = 3.19;
        if(gpa >= 3.6){
            System.out.println("Bằng xuat sac");
        }else if(gpa >= 3.2){
            System.out.println("Bang gioi");
        } else if (gpa >= 2.5) {
            System.out.println("Bang kha");
        } else {
            System.out.println("Bang trung binh");
        }

        // 5. SWITCH CASE CÓ NHẬP DỮ LIỆU
        System.out.print("Nhập số tương ứng với ngày (1-7): ");
        int day = scanner.nextInt();
        switch (day) {
            case 1:
                System.out.println("Thứ Hai"); break;
            case 2:
                System.out.println("Thứ Ba"); break;
            case 3:
                System.out.println("Thứ Tư"); break;
            case 4:
                System.out.println("Thứ Năm"); break;
            case 5:
                System.out.println("Thứ Sáu"); break;
            case 6:
                System.out.println("Thứ Bảy"); break;
            case 7:
                System.out.println("Chủ Nhật"); break;
            default:
                System.out.println("Không rõ ngày");
        }

        // 6. VÒNG LẶP FOR
        for (int i = 1; i <= 5; i++) {
            System.out.println("FOR: i = " + i);
        }

        // Ví dụ 1: Tính tổng các số từ 1 đến 10
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println("Tổng từ 1 đến 10 là: " + sum);

        // Ví dụ 2: In ra bảng cửu chương của 7
        int number = 7;
        System.out.println("Bảng cửu chương của " + number + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }

        // 7. VÒNG LẶP WHILE
        int j = 1;
        while (j <= 3) {
            System.out.println("WHILE: j = " + j);
            j++;
        }

        // Ví dụ 1: Nhập mật khẩu đúng mới cho tiếp tục
        String password;
        do {
            System.out.print("Nhập mật khẩu: ");
            password = scanner.next();
        } while (!password.equals("1234"));
        System.out.println("Mật khẩu đúng!");

        // 8. DO-WHILE
        int k = 1;
        do {
            System.out.println("DO-WHILE: k = " + k);
            k++;
        } while (k <= 2);

        //ví dụ 1: check người dùng
        String username;
        do {
            System.out.print("Nhập tên người dùng (admin): ");
            username = scanner.next();
        } while (!username.equals("admin"));
        System.out.println("Xin chào admin!");


        // 9. BREAK, CONTINUE, RETURN
        for (int n = 1; n <= 5; n++) {
            if (n == 2) continue;         // Bỏ qua n = 2
            if (n == 4) break;            // Dừng vòng lặp tại n = 4
            System.out.println("Vòng n = " + n);
        }

        testReturnExample();
        scanner.close();
    }

    static void testReturnExample() {
        System.out.println("Trước return");
        return; // Thoát khỏi hàm
        // System.out.println("Sau return"); // Lỗi nếu bỏ comment
    }
}
