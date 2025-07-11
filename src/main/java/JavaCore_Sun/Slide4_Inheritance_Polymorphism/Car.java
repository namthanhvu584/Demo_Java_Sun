package JavaCore_Sun.Slide4_Inheritance_Polymorphism;


public class Car extends Vehicle {
    private int numberOfDoors;


    public Car(String brand, int year, int numberOfDoors) {
        super(brand, year);   //Dùng từ khóa super để gọi constructor lớp cha
        this.numberOfDoors = numberOfDoors;
    }

    //Method overriding: ghi đè phương thức move của lớp cha
    @Override
    public void move() {
        System.out.println("Car is moving on roads.");
    }

    //Method overloading: cùng tên nhưng khác tham số
    public void move(String roadType) {
        System.out.println("Car is moving on " + roadType);
    }

    public void showDetails() {
        super.displayInfo();
        System.out.println("Doors: " + numberOfDoors);
    }
}