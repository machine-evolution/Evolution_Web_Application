package evolution.framework;

import evolution.framework.annotation.MyComponent;
import evolution.framework.service.MyService0;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class MyApplication {
    public Map<String, Object> componentMap;

    public MyApplication() {
        // Make componentMap not null.
    }

    public void scan() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        System.out.println(MyService0.class.getName());
        for (int i = 0; i < 4; i++) {
            String className = "evolution.framework.service.MyService" + i;
            Class clazz = Class.forName(className);
            Annotation annotation = clazz.getAnnotation(MyComponent.class);
            if (annotation != null) {
                Object object = clazz.getConstructor().newInstance();
//                this.componentMap.put(className, object);
            }
        }
    }
}
