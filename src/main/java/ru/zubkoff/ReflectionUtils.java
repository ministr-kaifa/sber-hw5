package ru.zubkoff;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.stream.Stream;

public class ReflectionUtils {

  /**
   * @param clazz
   * @return String representing all declared class methods in each row
   */
  public static String allMethodsFormated(Class<?> clazz) {
    return String.join("\n", Stream.of(clazz.getDeclaredMethods()).map(Method::toString).toList());
  }

  /**
   * @param clazz
   * @return String representing all declared class methods in each row
   */
  public static String allGetersFormated(Class<?> clazz) {
    return String.join("\n", Stream.of(clazz.getMethods())
        .filter(method -> method.getName().matches("get.*"))
        .map(Method::toString)
        .toList());
  }

  /**
   * @param clazz
   * @return true if the contents of all string constants of the class are equal to their names, otherwise false
   */
  public static boolean isAllStringConstantsContentEqualsToName(Class<?> clazz) {
    return Stream.of(clazz.getFields())
      .filter(field -> Modifier.isStatic(field.getModifiers()) && Modifier.isFinal(field.getModifiers()))
      .filter(field -> field.getType().equals(String.class))
      .allMatch(field -> {
        try {
          field.setAccessible(true);
          return field.getName().equalsIgnoreCase((String)field.get(null));
        } catch (IllegalArgumentException | IllegalAccessException e) {
          throw new RuntimeException(e);
        }
      });
  }

}
