package JavaCore_Sun.Slide4_Inheritance_Polymorphism;


public class Bike extends Vehicle {
    private boolean hasPedals;

    public Bike(String brand, int year, boolean hasPedals) {
        super(brand, year);
        this.hasPedals = hasPedals;
    }

    @Override
    public void move() {
        System.out.println("Bike is moving on bike lanes.");
    }

    public void showDetails() {
        super.displayInfo();
        System.out.println("Has pedals: " + hasPedals);
    }
}




