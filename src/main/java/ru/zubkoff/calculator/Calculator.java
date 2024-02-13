package ru.zubkoff.calculator;

import ru.zubkoff.benchmark.Metric;

public interface Calculator {
	/**
	* Расчет факториала числа.
	* @param number 
  * @throws IllegalArumentException when argument < 0
	*/
	int calc (int number);
}
