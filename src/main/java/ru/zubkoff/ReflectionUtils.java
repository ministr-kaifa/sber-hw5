package ru.zubkoff;

import java.lang.reflect.Method;
import java.util.stream.Stream;

public class ReflectionUtils {
  
  /**
   * @param clazz
   * @return String representing all declared clazz methods in each row
   */
  public static String allMethodsFormated(Class<?> clazz) {
    return String.join("\n", Stream.of(clazz.getDeclaredMethods()).map(Method::toString).toList());
  }

  /**
   * @param clazz
   * @return String representing all declared clazz methods in each row
   */
  public static String allGetersFormated(Class<?> clazz) {
    return String.join("\n", Stream.of(clazz.getMethods())
      .filter(method -> method.getName().matches("get.*"))
      .map(Method::toString)
      .toList());
  }





}
