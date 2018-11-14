package pl.p.lodz.dmcs.ptoish;

public class Test2 implements Testable {
    @Override
    public void test() {
        System.out.println("Test2 also displays different message");
    }

    @Override
    public int getField() {
        return 0;
    }

    @Override
    public String getPublic() {
        return null;
    }
}
