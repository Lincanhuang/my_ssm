package ch.my.framework.shiro.session;

import org.apache.shiro.cache.AbstractCacheManager;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

import ch.my.framework.shiro.cache.ShiroCache;

public class ShiroRepository<K,V> extends  AbstractCacheManager {

	@Override
	protected Cache<K, V> createCache(String name) throws CacheException {
		return new ShiroCache<K, V>(name);
	}

}
