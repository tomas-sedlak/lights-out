package sk.srobarka.lightsOut.core;

// use 📀, 💿 in console for lights

public class Light {
    private boolean on;

    public Light () {
        this.on = false;
    }

    public boolean isOn() {
        return this.on;
    }

    public void toggle() {
        this.on = !this.on;
    }
}
