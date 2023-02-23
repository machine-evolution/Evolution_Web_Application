package evolution.java.interface_;

public class WiredClass implements BizarreInterface, StrangeInterface {
    @Override
    public void abstractMethod() {
        System.out.println("This is no longer an abstract method.");
    }

    @Override
    public void defaultMethod() {
        BizarreInterface.super.defaultMethod();
        StrangeInterface.super.defaultMethod();
    }
}
