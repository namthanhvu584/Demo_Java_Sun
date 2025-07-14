
package JavaCore_Sun.Slide8;

import java.io.*;

public class DemoException {
    public static void main(String[] args) {

        //  Chia cho 0 – Unchecked Exception
        try {
            int a = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Lỗi: chia cho 0");
        }

        //  Đọc file – Checked Exception
        try {
            FileReader fr = new FileReader("khongtontai.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi: Không tìm thấy file!");
        }

        //  finally – luôn chạy
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("Lỗi: Biến null");
        } finally {
            System.out.println("[finally] Dù có lỗi hay không đều chạy");
        }

        //  throw – ném lỗi có chủ ý
        try {
            kiemTraTuoi(15); // Tuổi nhỏ hơn 18 sẽ ném lỗi
        } catch (IllegalArgumentException e) {
            System.out.println(" Tuổi không hợp lệ: " + e.getMessage());
        }

        //  throws – khai báo lỗi có thể xảy ra
        try {
            docFile("duongdan.txt");
        } catch (IOException e) {
            System.out.println("Không thể đọc file: " + e.getMessage());
        }

        //  Nested try
        try {
            try {
                int[] arr = new int[2];
                arr[5] = 10; // lỗi vượt chỉ số
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Lỗi mảng vượt chỉ số");
            }

            String s = null;
            System.out.println(s.length()); // lỗi null

        } catch (NullPointerException e) {
            System.out.println("Lỗi biến null");
        }

        //  User-defined exception (tự định nghĩa ngoại lệ)
        try {
            dangKy("", 17); // thiếu tên hoặc tuổi nhỏ sẽ gây lỗi
        } catch (InvalidInputException e) {
            System.out.println(" Ngoại lệ tự định nghĩa: " + e.getMessage());
        }
    }

    //  Phương thức dùng throw để ném lỗi
    static void kiemTraTuoi(int tuoi) {
        if (tuoi < 18) {
            throw new IllegalArgumentException("Tuổi phải >= 18");
        }
        System.out.println("Tuổi hợp lệ");
    }

    //  Phương thức khai báo throws
    static void docFile(String path) throws IOException {
        FileReader f = new FileReader(path);
        f.close();
    }

    //  Dùng ngoại lệ tự định nghĩa
    static void dangKy(String ten, int tuoi) throws InvalidInputException {
        if (ten.isEmpty()) {
            throw new InvalidInputException("Tên không được để trống");
        }
        if (tuoi < 18) {
            throw new InvalidInputException("Tuổi phải >= 18");
        }
        System.out.println("Đăng ký thành công");
    }
}

//  Ngoại lệ do lập trình viên định nghĩa
class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
} //  Thường dùng cho quy tắc kiểm tra dữ liệu người dùng
