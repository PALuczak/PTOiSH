package pl.p.lodz.dmcs.ptoish;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.List;

public class Exercise42 {
    public static void main(String[] args) throws InterruptedException {
        ReferenceQueue q = new ReferenceQueue();
        PhantomReference<ReferenceTest> phantomRef = new PhantomReference<>(new ReferenceTest("PHANOM"), q);
        SoftReference<ReferenceTest> softRef = new SoftReference<>(new ReferenceTest("SOFT"), q);
        WeakReference<ReferenceTest> weakRef = new WeakReference<>(new ReferenceTest("WEAK"), q);
        List<Integer> memWaster = new ArrayList<>();
        int count = 0;

        while(true) {
            try {
                for (int i = count; i < count + 10000; i++) {
                    memWaster.add(i);
                }
            } catch (OutOfMemoryError E) {
                System.out.println("OutOfMemoryError");
            }
            if(softRef.get() != null) System.out.println("Soft is reachable until OutOfMemoryError");
            if(weakRef.get() != null) System.out.println("Weak reachable until GC occurs");
            if(phantomRef.get() == null) System.out.println("Phantom.get() is always null");
            if(softRef.get() == null && weakRef.get() == null) break;
            Thread.sleep(1000);
            System.gc();
        }
    }
}
