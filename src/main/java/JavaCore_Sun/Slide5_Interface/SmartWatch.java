package JavaCore_Sun.Slide5_Interface;

public class SmartWatch implements SmartDevice {
    private String brand;

    public SmartWatch(String brand) {
        this.brand = brand;
    }

    @Override
    public void turnOn() {
        System.out.println("Smartwatch is turning on...");
    }

    @Override
    public void turnOff() {
        System.out.println("Smartwatch is turning off...");
    }

    @Override
    public String getDeviceInfo() {
        return "Smartwatch brand: " + brand;
    }
}
