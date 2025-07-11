package JavaCore_Sun.Slide4_Inheritance_Polymorphism;

public class Main {
    public static void main(String[] args) {
        // Polymorphism (đa hình): dùng kiểu cha để chứa đối tượng con

        Vehicle a = new Car("Honda", 2000, 4);
        Vehicle b = new Bike("Vision", 2004, true);
        //gọi phương thức override
        a.move();
        b.move();

        //Method overloading: cùng tên nhưng khác tham số
        ((Car) a).move("highway");

        // Gọi phương thức riêng của từng subclass
        ((Car) a).showDetails();
        ((Bike) b).showDetails();

        // Dùng class final (không kế thừa được)
        ElectricScooter es1 = new ElectricScooter();
        es1.showBattery();
        es1.charge();
    }
}
