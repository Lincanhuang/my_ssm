package ch.my.framework.shiro.cache;

import java.util.Map;

import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.MapCache;

public class ShiroCache<K, V> extends MapCache<K, V> {
	
	public ShiroCache(String name, Map<K, V> backingMap) {
		super(name, backingMap);
	}

	
	

	@Override
	public V remove(K key) throws CacheException {
		System.out.println(key);
		return super.remove(key);
	}

	@Override
	public V get(K key) throws CacheException {
		System.out.println(key);
        return super.get(key);
    }



	
}
