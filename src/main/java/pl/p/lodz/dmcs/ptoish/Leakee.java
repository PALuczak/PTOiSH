package pl.p.lodz.dmcs.ptoish;

public class Leakee {
    public void check() {
        if (depth > 2) {
            Exercise52.done();
        }
    }

    private int depth;

    public Leakee(int d) {
        depth = d;
    }

    protected void finalize() {
        new Leakee(depth + 1).check();
        new Leakee(depth + 1).check();
    }
}
