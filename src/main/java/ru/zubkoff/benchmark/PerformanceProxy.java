package ru.zubkoff.benchmark;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class PerformanceProxy implements MethodInterceptor {

  private final Object proxied;

  public PerformanceProxy(Object proxied) {
    this.proxied = proxied;
  }
  
  @Override
  public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
    if(!method.isAnnotationPresent(Metric.class)) {
      return call(method, args);
    }
    long startTime = System.nanoTime();
    var result = call(method, args);
    System.out.println("Время работы метода: " + (System.nanoTime() - startTime) + "(в наносек)");
    return result;
  }

  public static <T> T newInstance(T target) {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(target.getClass());
    enhancer.setCallback(new PerformanceProxy(target));
    return (T)enhancer.create();
  }

  private Object call(Method method, Object[] args) {
    try {
      return method.invoke(proxied, args);
    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
      throw new RuntimeException(e);
    }
  }
}
