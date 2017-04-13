package annotation.demo;

import java.lang.reflect.*;

public class FruitInfoUtil {
    public static <T> String getFruitInfo(Class<T> clazz, String pathValue, String fruitName) throws Exception {
        Fruit f = null;

        T obj = clazz.newInstance();
        for (Method method : clazz.getDeclaredMethods()) {
            MyPath path = (MyPath)method.getAnnotation(MyPath.class);

            // check uri is match
            if (path != null && path.value().equals(pathValue)) {
                f = (Fruit)method.invoke(obj, fruitName);
            }
        }

        if (f == null) {
            return "Bad request, an not found fruit!";
        }
        return f.toString();
    }
}
