package JavaCore_Sun.Slide5_Interface;

// SmartPhone implements cả SmartDevice và SmartDeviceManager.Controllable
public class SmartPhone implements SmartDevice, SmartDeviceManager.Controllable {
    private String model;

    public SmartPhone(String model) {
        this.model = model;
    }

    @Override
    public void turnOn() {
        System.out.println("Smartphone is turning on...");
    }

    @Override
    public void turnOff() {
        System.out.println("Smartphone is turning off...");
    }

    @Override
    public String getDeviceInfo() {
        return "Smartphone model: " + model;
    }

    @Override
    public void restart() {
        System.out.println("Smartphone is restarting...");
    }
}
