package pl.p.lodz.dmcs.ptoish;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Exercise32 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Testable test = new Test();

        Method method0 = Testable.class.getMethod("test", null);
        Method method1 = Testable.class.getMethod("getField", null);

        System.out.println("Invoke test()");
        method0.invoke(test, null);
        System.out.println("Invoke private getter");
        System.out.println(method1.invoke(test, null));
        System.out.println("Get public from class");
        System.out.println(((Test) test).publicField);

    }
}
