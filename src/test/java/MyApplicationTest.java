import evolution.framework.MyApplication;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class MyApplicationTest {
    @Test
    public void test() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        MyApplication application = new MyApplication();
        application.scan();
    }
}
