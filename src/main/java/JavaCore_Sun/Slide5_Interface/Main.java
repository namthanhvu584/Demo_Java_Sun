package JavaCore_Sun.Slide5_Interface;


public class Main {
    public static void main(String[] args) {
        SmartDevice phone = new SmartPhone("Galaxy S24");
        SmartDevice watch = new SmartWatch("Apple");

        // Đa hình: gọi phương thức qua interface
        phone.turnOn();
        System.out.println(phone.getDeviceInfo());

        watch.turnOn();
        System.out.println(watch.getDeviceInfo());

        // Gọi phương thức nested interface
        SmartDeviceManager.Controllable ctrl = (SmartDeviceManager.Controllable) phone;
        ctrl.restart();
    }
}
