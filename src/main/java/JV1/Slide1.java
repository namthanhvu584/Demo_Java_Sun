package JV1;

// Lớp chính để chạy chương trình
//public class Slide1 {
//    public static void main(String[] args) {
//        // Tạo một đối tượng Person bằng cách sử dụng constructor
//        Person p1 = new Person("Nam", 21, "Hà Nội");
//
//        // Gọi phương thức công khai
//        p1.introduce();
//
//        // Truy cập biến private thông qua getter
//        System.out.println("Tuổi hiện tại (qua getter): " + p1.getAge());
//
//        // Cập nhật biến private thông qua setter
//        p1.setAge(22);
//        System.out.println("Tuổi sau khi cập nhật: " + p1.getAge());
//    }
//}

public class Slide1 {
    public static void main(String[] args) {
        //Tao object Person
        Person p1 = new Person("Nam", 21, "Ha Noi");
        p1.introduced();
    }
}
//Tao lop Person
class Person {
    public String name;
    private int age;
    protected String address;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    public void introduced(){
        System.out.println("My name is: " + name + " I'm " + age + " year old and I'm living in " + address);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age > 0) {
            this.age = age;
        }
    }

}
// Các khái niệm OOP trong Java: Class, Object, Access Modifier, Variable, Constructor, Method

//// 1. CLASS (Lớp)
//class Person {
//
//    // 2. ACCESS MODIFIERS & VARIABLES (Phạm vi truy cập & biến)
//    public String name;        // Public: có thể truy cập từ bất kỳ đâu
//    private int age;           // Private: chỉ truy cập được trong nội bộ lớp
//    protected String address;  // Protected: truy cập được trong cùng package và các lớp kế thừa
//
//    // 3. CONSTRUCTOR (Hàm khởi tạo)
//    public Person(String name, int age, String address) {
//        this.name = name;
//        this.age = age;
//        this.address = address;
//    }
//
//    // 4. METHOD (Phương thức)
//    public void introduce() {
//        System.out.println("Xin chào, tôi tên là " + name + ", tôi " + age + " tuổi và sống ở " + address + ".");
//    }
//
//    private void secret() {
//        System.out.println("Đây là phương thức bí mật.");
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        if (age > 0) {
//            this.age = age;
//        }
//    }
//}
