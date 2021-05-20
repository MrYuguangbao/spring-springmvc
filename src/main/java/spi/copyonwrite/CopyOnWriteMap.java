package spi.copyonwrite;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author admin
 * @date 2020/4/9 16:34
 */
public class CopyOnWriteMap<K,V> implements Map<K,V>,Cloneable {

    private volatile Map<K,V> interMap;

    public CopyOnWriteMap(){
        interMap = new HashMap<>();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        return interMap.get(key);
    }

    @Override
    public V put(K key, V value) {
        synchronized (this){
            Map<K,V> newMap = new HashMap<>(interMap);
            V put = newMap.put(key, value);
            interMap = newMap;
            return put;
        }

    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        synchronized (this){
            Map<K,V> newMap = new HashMap<>(interMap);
            newMap.putAll(m);
            interMap = newMap;
        }
    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
