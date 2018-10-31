package pl.p.lodz.dmcs.ptoish;

public class Test implements Testable {
    private int privateField = 42;
    public String publicField = "24";
    @Override
    public void test() {
        System.out.println("Writing to console in this method");
    }

    @Override
    public int getField() {
        return privateField;
    }

    @Override
    public String getPublic() {
        return publicField;
    }
}
