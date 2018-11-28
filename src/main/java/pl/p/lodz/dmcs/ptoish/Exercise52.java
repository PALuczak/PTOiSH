package pl.p.lodz.dmcs.ptoish;

public class Exercise52 {
    private static boolean makeMore = true;

    public static void done() {
        makeMore = false;
    }

    public static void main(String args[]) throws InterruptedException {
        while (makeMore) {
            new Leakee(0).check();
        }
        while (true) {
            Thread.sleep(1000);
            System.out.println("memory=" +
                    Runtime.getRuntime().freeMemory() + " / " +
                    Runtime.getRuntime().totalMemory());
        }
    }
}
