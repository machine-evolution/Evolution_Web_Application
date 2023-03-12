package evolution.pattern.bridge.automobile;

import evolution.pattern.bridge.transmission.Transmission;

public abstract class Automobile {
    public Transmission transmission;

    public abstract void run();
}
