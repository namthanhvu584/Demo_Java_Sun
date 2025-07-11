package JavaCore_Sun;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Slide3 {
    public static void main(String[] args) {
        stringDemo();
        arrayDemo();
        array2DDemo();
        dateTimeDemo();
        dateTimeAdvanced();
    }

    // 1. DEMO CHUỖI
    public static void stringDemo() {
        System.out.println("--- String Demo ---");
        String s1 = "Hello Harry";
        System.out.println("Length: " + s1.length());
        System.out.println("Second char: " + s1.charAt(1));
        System.out.println("Upper case: " + s1.toUpperCase());
        System.out.println("SubString: " + s1.substring(2, 8));
        System.out.println("Contains 'Harry'? " + s1.contains("Harry"));
        System.out.println("Replace 'Harry' -> 'Nam': " + s1.replace("Harry", "Nam"));
        String[] words = s1.split(" ");
        System.out.println("Split words:");
        for (String w : words) System.out.println(w);
        System.out.println("Is Empty? " + s1.isEmpty());
        System.out.println("String.valueOf(123): " + String.valueOf(123));
    }

    // 2. MẢNG 1 CHIỀU
    public static void arrayDemo() {
        System.out.println("\n--- Array 1D Demo ---");
        int[] nums = {1, 3, 5, 7};
        for (int i = 0; i < nums.length; i++) {
            System.out.println("Element at index " + i + ": " + nums[i]);
        }
    }

    // 3. MẢNG 2 CHIỀU
    public static void array2DDemo() {
        System.out.println("\n--- Array 2D Demo ---");
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 4. NGÀY GIỜ CƠ BẢN
    public static void dateTimeDemo(){
        LocalDate today = LocalDate.now();
        System.out.println("Today: " + today);

        LocalTime time = LocalTime.now();
        System.out.println("Time Now: " + time);

        LocalDateTime dt = LocalDateTime.now();
        System.out.println("RightNow: " + dt);

        LocalDate myBirthday;
        myBirthday = LocalDate.of(2004, 06, 05);
        System.out.println("My BirthDay: " + myBirthday);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formatted = dt.format(formatter); //format thanh string
        System.out.println("Dinh Dang: " + formatted);
    }
    // 5. NGÀY GIỜ NÂNG CAO: parse, localized
    public static void dateTimeAdvanced() {
        // 1. parse() - chuyển từ chuỗi sang ngày/giờ
        String input = "2025-07-10";
        LocalDate parsedDate = LocalDate.parse(input); // parse()
        System.out.println("Parsed Date: " + parsedDate);

        // 2. Localized Date
        LocalDate now = LocalDate.now();
        DateTimeFormatter fullDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        System.out.println("Ngày (FULL): " + now.format(fullDate));

        // 3. Localized Time
        LocalTime nowTime = LocalTime.now();
        DateTimeFormatter shortTime = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        System.out.println("Giờ (SHORT): " + nowTime.format(shortTime));

        // 4. Localized DateTime
        LocalDateTime nowDT = LocalDateTime.now();
        DateTimeFormatter dtMedium = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        System.out.println("Ngày giờ (MEDIUM): " + nowDT.format(dtMedium));

        // 5. Localized DateTime với 2 kiểu
        DateTimeFormatter dtCustom = DateTimeFormatter.ofLocalizedDateTime(
                FormatStyle.LONG, FormatStyle.SHORT);
        System.out.println("Ngày giờ (LONG + SHORT): " + nowDT.format(dtCustom));
    }
}
