package pl.p.lodz.dmcs.ptoish;

public class Test1 implements Testable {
    @Override
    public void test() {
        System.out.println("Test1 displays different message");
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
