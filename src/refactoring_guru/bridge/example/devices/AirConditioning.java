package refactoring_guru.bridge.example.devices;

import org.w3c.dom.ranges.RangeException;

public class AirConditioning implements Device {
    private boolean enabled = false;
    private int temperature = 26;
    private int mode = 0; // 0 means cool; 1 means hot

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void enable() {
        this.enabled = true;
    }

    @Override
    public void disable() {
        this.enabled = false;
    }

    @Override
    public int getVolume() {
        return temperature;
    }

    @Override
    public void setVolume(int percent) {
        this.temperature = percent;
    }

    @Override
    public int getChannel() {
        return mode;
    }

    @Override
    public void setChannel(int channel) {
        if (channel != 0 && channel != 1) {
            System.out.println("air conditioning channel must in 0 or 1, set default 0");
            this.mode = 0;
            return;
        }
        this.mode = channel;
    }

    @Override
    public void printStatus() {
        System.out.println("------------------------------------");
        System.out.println("| I'm air conditioning.");
        System.out.println("| I'm " + (enabled ? "enabled" : "disabled"));
        System.out.println("| Current temperature is " + temperature + "'C");
        System.out.println("| Current mode is " + (this.mode == 0 ? "cool" : "hot"));
        System.out.println("------------------------------------\n");
    }

    @Override
    public int getDefaultVolume() {
        return 26;
    }
}
