package JavaCore_Sun.Slide4_Inheritance_Polymorphism;

// abstract class (lớp trừu tượng)
public abstract class Vehicle{
    protected String brand;
    protected int year;

    public Vehicle(String brand, int year){
        this.brand = brand;
        this.year = year;
    }

    public void displayInfo(){
        System.out.println("Brand: " + brand + ", Year: " + year);
    }

    // abstract method: bắt buộc lớp con phải override
    public abstract void move();

}
