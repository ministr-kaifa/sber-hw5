package ru.zubkoff;

import java.util.stream.IntStream;

public class CalculatorImpl implements Calculator {

  @Override
  public int calc(int number) {
    if(number < 0) {
      throw new IllegalArgumentException("number argument cant be negative");
    }
    
    return IntStream.rangeClosed(2, number)
      .reduce(1, (x, y) -> x * y);
  }
  
}
