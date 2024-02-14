package ru.zubkoff.cache;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * Proxy wrapper for global caching of method call results 
 */
public class CachedInvocationHandler implements MethodInterceptor {

  private static final Map<Method, Map<List<Object>, Object>> cache = new HashMap<>();
  private final Object proxied;

  public CachedInvocationHandler(Object proxied) {
    this.proxied = proxied;
  }
  
  @Override
  public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
    if (method.isAnnotationPresent(Cached.class)) {
      return cache.computeIfAbsent(method, newCachedMethod -> new HashMap<>())
        .computeIfAbsent(List.of(args), firstlyCalledArgs -> call(method, args));
    } else {
      return call(method, args);
    }
  }

  /**
   * Creates new cache proxy wrapper instance
   * @param target object to be wrapped
   * @return new cache proxy wrapper instance
   */
  public static <T> T newInstance(T target) {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(target.getClass());
    enhancer.setCallback(new CachedInvocationHandler(target));
    return (T)enhancer.create();
  }

  private Object call(Method method, Object[] args) {
    try {
      return method.invoke(proxied, args);
    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
      throw new RuntimeException(e);
    }
  }
  
  /**
   * Evicts the cache
   */
  public static void evict() {
    cache.clear();
  }

}