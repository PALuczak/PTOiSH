package pl.p.lodz.dmcs.ptoish;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheMapTime<K, V> extends ConcurrentHashMap<K, V> {
    private Map<K, Long> timeoutMap = new ConcurrentHashMap<>();
    private static long TIMEOUT = 5000;
    private static long SLEEPTIME = TIMEOUT/4; // so as to not miss the moment of invalidation
    private Thread invalidationThread = new Invalidator();

    CacheMapTime() {
        invalidationThread.start();
    }

    @Override
    public V put(K key, V value) {
        countdownStart(key);
        return super.put(key, value);
    }

    protected void countdownStart(K key) {
        long current = System.nanoTime() / 10000;
        timeoutMap.put(key, current);
    }

    @Override
    public V putIfAbsent(K key, V value) {
        if (!containsKey(key))
            return put(key, value);
        else
            return get(key);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (K key : m.keySet()) {
            put(key, m.get(key));
        }
    }

    class Invalidator extends Thread {
        @Override
        public void run() {
            while (true) {
                invalidate();
                try {
                    Thread.sleep(SLEEPTIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void invalidate() {
            long current = System.nanoTime() / 10000;
            for (K key : timeoutMap.keySet()) {
                if (current - TIMEOUT > (timeoutMap.get(key))) {
                    remove(key);
                    timeoutMap.remove(key);
                }
            }
        }

    }
}
