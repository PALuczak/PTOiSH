package pl.p.lodz.dmcs.ptoish;

// Least recently used approach
public class CacheMapLRU<K, V> extends CacheMapTime<K, V> {
    @Override
    public V get(Object key) {
        countdownStart((K) key);
        return super.get(key);
    }
}
