package ru.zubkoff.calculator;

import ru.zubkoff.cache.Cached;

public class SlowCalculator extends CalculatorImpl {

  @Cached
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
