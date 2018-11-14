package pl.p.lodz.dmcs.ptoish;

import java.lang.reflect.*;

public class Exercise41 {

    public static void main(String[] args) {
        try {
            Testable tt1 = new Test1();
            tt1.test();
            Testable tt2 = new Test2();
            tt2.test();
            Testable t1 = (Testable) TestHandler.newInstance(new Test1());
            Testable t2 = (Testable) TestHandler.newInstance(new Test2());;
            t1.test();
            t2.test();
        } catch (UndeclaredThrowableException e) {
            Throwable ee = e.getUndeclaredThrowable();
            e.printStackTrace();
        }
    }
}
