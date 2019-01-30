package ch.my.framework.shiro.cache;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.shiro.cache.AbstractCacheManager;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.MapCache;
import org.apache.shiro.session.Session;
import org.apache.shiro.util.SoftHashMap;

public class ShiroCacheManager extends AbstractCacheManager {

    /**
     * Returns a new {@link MapCache MapCache} instance backed by a {@link SoftHashMap}.
     *
     * @param name the name of the cache
     * @return a new {@link MapCache MapCache} instance backed by a {@link SoftHashMap}.
     */
    @Override
    protected Cache<Serializable, Session> createCache(String name) {
        return new ShiroCache<Serializable, Session>(name, new ConcurrentHashMap<>());
    }
}