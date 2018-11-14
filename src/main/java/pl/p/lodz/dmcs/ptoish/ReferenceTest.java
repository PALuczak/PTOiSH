package pl.p.lodz.dmcs.ptoish;

public class ReferenceTest {
    private String name;

    public ReferenceTest(String val) {
        name = val;
        System.out.println(name+" created");
    }

    public ReferenceTest() {
        name = "Unnamed";
        System.out.println(name+" created");
    }

    protected void finalize(){
        System.out.println(name+" finalized");
    }
}
