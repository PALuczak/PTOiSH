package pl.p.lodz.dmcs.ptoish;

import java.util.Map;
import java.util.TreeMap;

public class Exercise31 {
    public static void main(String[] args) {
        Map placeholder = new TreeMap();
        CacheMapTime timeCache = new CacheMapTime();
        CacheMapLRU lruCache = new CacheMapLRU();

        System.out.println("Warming up the JVM");
        for (int i = 0; i < 10000; i++) {
            placeholder.put(i, i);
            placeholder.get(i);
        }

        System.out.println("Putting 5 vals");
        System.out.println("Timed");
        MyBenchmark.printTime(() -> insertVals(timeCache));
        System.out.println("LRU");
        MyBenchmark.printTime(() -> insertVals(lruCache));

        System.out.println("Getting 5 vals");
        System.out.println("Timed");
        MyBenchmark.printTime(() -> readVals(timeCache));
        System.out.println("LRU");
        MyBenchmark.printTime(() -> readVals(lruCache));

        System.out.println("Pretending to work");
        try {
            while (true) {
                Thread.sleep(100);
                if (timeCache.get("Answer") == null) throw new Exception("Unable to access time cached value");
                if (lruCache.get("Answer") == null) throw new Exception("Unable to access LRU cached value");
                System.out.println("Read both values");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    private static void insertVals(CacheMapTime cacheMap) {
        cacheMap.put("Answer", 42);
        cacheMap.put("Magic", 8);
        cacheMap.put("MoreMagic", 88);
        cacheMap.put("LessMagic", 7);
        cacheMap.put("NoMagic", 0);
    }

    private static void readVals(CacheMapTime cacheMap) {
        cacheMap.get("Answer");
        cacheMap.get("Magic");
        cacheMap.get("MoreMagic");
        cacheMap.get("LessMagic");
        cacheMap.get("NoMagic");
    }
}
