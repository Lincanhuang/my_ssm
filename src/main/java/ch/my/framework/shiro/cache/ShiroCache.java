package ch.my.framework.shiro.cache;

import java.util.Collection;
import java.util.Set;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.lang.Nullable;

public class ShiroCache<K, V> implements Cache<K, V> {
	
	@Nullable
	private javax.cache.CacheManager cacheManager;
	
	private javax.cache.Cache<K, V> jCacheCache;
	
	public ShiroCache(String cacheName) {
		jCacheCache = cacheManager.getCache(cacheName);
	}
	
	@Override
	public V get(K key) throws CacheException {
		return jCacheCache.get(key);
	}

	@Override
	public V put(K key, V value) throws CacheException {
		return jCacheCache.getAndPut(key, value);
	}

	@Override
	public V remove(K key) throws CacheException {
		return jCacheCache.getAndRemove(key);
	}

	@Override
	public void clear() throws CacheException {
		jCacheCache.clear();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Set<K> keys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}


	
}
