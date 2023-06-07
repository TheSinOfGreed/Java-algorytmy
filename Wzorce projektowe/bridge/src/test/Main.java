package test;

public class Main {

    public static void main(String[] args) {
        testDevice(new TV());
        testDevice(new Radio());
    }
    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        Remote basicRemote = new Remote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}
