package ru.zubkoff;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BeanUtils {
  /**
   * Scans object "from" for all getters. If object "to"
   * contains correspondent setter, it will invoke it
   * to set property value for "to" which equals to the property
   * of "from".
   * <p/>
   * The type in setter should be compatible to the value returned
   * by getter (if not, no invocation performed).
   * Compatible means that parameter type in setter should
   * be the same or be superclass of the return type of the getter.
   * <p/>
   * The method takes care only about public methods.
   *
   * @param to   Object which properties will be set.
   * @param from Object which properties will be used to get values.
   */
  public static void assign(Object to, Object from) {
    var setableFields = Stream.of(to.getClass().getMethods())
      .filter(method -> method.getName().matches("set.*"))
      .collect(Collectors.toMap(BeanUtils::fieldName, seter -> seter));

    Stream.of(from.getClass().getMethods())
      .filter(method -> method.getName().matches("get.*"))
      .filter(geter -> setableFields.containsKey(fieldName(geter)))
      .filter(geter -> setableFields.get(fieldName(geter)).getParameterTypes()[0].isAssignableFrom(geter.getReturnType()))
      .forEach(geter -> {
        try {
          setableFields.get(fieldName(geter)).invoke(to, geter.invoke(from));
        } catch (IllegalAccessException | InvocationTargetException e) {
          throw new RuntimeException(e);
        }
      });
  }

  private static String fieldName(Method method) {
    return method.getName().substring(3);
  }

}
