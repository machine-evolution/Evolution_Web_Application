package evolution.java.interface_;

public interface BizarreInterface {

    public void abstractMethod();

    public default void defaultMethod() {
        System.out.println("This is a default method");
    }

    public static void staticMethod() {
        System.out.println("This is a static method");
    }

    private void privateMethod() {
        System.out.println("This is a private method");
    }
}
