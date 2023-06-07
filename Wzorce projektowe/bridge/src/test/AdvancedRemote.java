package test;


public class AdvancedRemote extends Remote {

    public AdvancedRemote(Device device) {
        super();
        super.device = device;
    }

    public void mute() {
        System.out.println("Remote: mute");
        device.setVolume(0);
    }
}
