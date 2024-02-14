package ru.zubkoff.calculator;

import static org.junit.Assert.assertArrayEquals;

import java.util.stream.IntStream;

import org.junit.Test;

public class CalculatorImplTest {

  @Test
  public void correctOutputTest() {
    int[] expectedOuts = {
      1, 1, 2, 6, 24, 120, 720, 5_040, 40_320,
      362_880, 3_628_800, 39_916_800,
      479_001_600
    };

    Calculator calculator = new CalculatorImpl();

    assertArrayEquals(
      expectedOuts, 
      IntStream.range(0, expectedOuts.length)
        .map(numberInput -> calculator.calc(numberInput))
        .toArray()
    );

  }
  
}
