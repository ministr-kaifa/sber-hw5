package ru.zubkoff;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class ReflectionUtilsTest {
  @Test
  public void isAllStringConstantsContentEqualsToNameTest() {
    assertTrue(ReflectionUtils.isAllStringConstantsContentEqualsToName(new Object() {}.getClass()));
    assertTrue(ReflectionUtils.isAllStringConstantsContentEqualsToName(new Object() {
      private final static int A = 1;
      private final static double B = 2.4;
    }.getClass()));

    assertTrue(ReflectionUtils.isAllStringConstantsContentEqualsToName(new Object() {
      private final static String A = "a";
      private final static String B = "B";
    }.getClass()));

    assertTrue(ReflectionUtils.isAllStringConstantsContentEqualsToName(new Object() {
      private final static String A = "a";
      private final static String B = "B";
      private final static int C = 1;
      private final static double D = 2.4;
    }.getClass()));

    assertFalse(ReflectionUtils.isAllStringConstantsContentEqualsToName(new Object() {
      private final static String A = "a";
      private final static String B = "A";
    }.getClass()));

    assertFalse(ReflectionUtils.isAllStringConstantsContentEqualsToName(new Object() {
      private final static String A = "";
    }.getClass()));
  }
}
