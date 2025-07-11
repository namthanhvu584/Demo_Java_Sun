package JavaCore_Sun.Slide4_Inheritance_Polymorphism;

// final class: không thể bị kế thừa
public final class ElectricScooter {
    // final variable: không thể thay đổi giá trị sau khi khởi tạo
    private final int batteryCapacity = 100;

    // final method: không thể bị override ở bất kỳ subclass nào
    public final void charge() {
        System.out.println("Charging to 100%");
    }

    public void showBattery() {
        System.out.println("Battery: " + batteryCapacity + "%");
    }
}
