package pl.p.lodz.dmcs.ptoish;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class MyBenchmark {

    public static <T> T printTime(Runnable task) {
        T call = null;
        try {
            long start = System.nanoTime();
            task.run();
            long end = System.nanoTime();
            System.out.print((end - start) * 1e-6);
            System.out.println(" ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return call;
    }

    public static <T> T printTimeMultiple(Runnable task) {
        return printTimeMultiple(task, 10);
    }

    public static <T> T printTimeMultiple(Runnable task, int iterations) {
        T call = null;
        try {
            List<Double> times = new ArrayList<>();
            for (int i = 0; i < iterations; i++) {
                long start = System.nanoTime();
                task.run();
                long end = System.nanoTime();
                times.add((end - start) * 1e-6);
            }
            double sum = 0;
            for (double i : times) sum += i;
            System.out.print("Average after " + iterations + " iterations ");
            System.out.print(sum / times.size());
            System.out.println(" ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return call;
    }

}