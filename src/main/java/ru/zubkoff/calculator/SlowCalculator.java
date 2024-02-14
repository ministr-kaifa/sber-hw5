package ru.zubkoff.calculator;

import ru.zubkoff.benchmark.Metric;
import ru.zubkoff.cache.Cached;

public class SlowCalculator extends CalculatorImpl {

  @Cached
  @Metric
  @Override
  public int calc(int number) {
    try {
      Thread.sleep(2_000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    return super.calc(number);
  }
  
}
