package ru.zubkoff.cache;

import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.Test;

import ru.zubkoff.calculator.Calculator;
import ru.zubkoff.calculator.SlowCalculator;

public class CachedInvocationHandlerTest {
  
  @Test
  public void cacheTimeTest() {
    Calculator calculator = CachedInvocationHandler.newInstance(new SlowCalculator());
    calculator.calc(0);
    assertTimeout(Duration.ofMillis(2_000), () -> calculator.calc(0));
  }

}
