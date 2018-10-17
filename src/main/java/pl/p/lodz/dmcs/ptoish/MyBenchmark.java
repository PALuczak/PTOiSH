package pl.p.lodz.dmcs.ptoish;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Callable;

public class MyBenchmark {

    public static <T> T printTime(Runnable task) {
        T call = null;
        try {
            Instant start = Instant.now();
            task.run();
            Instant end = Instant.now();
            System.out.println(Duration.between(start, end));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return call;
    }
}