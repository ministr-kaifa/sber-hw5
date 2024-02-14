package ru.zubkoff;

import ru.zubkoff.benchmark.PerformanceProxy;
import ru.zubkoff.cache.CachedInvocationHandler;
import ru.zubkoff.calculator.Calculator;
import ru.zubkoff.calculator.SlowCalculator;

public class Main {

  public static void main(String[] args) {

    System.out.println("\nTask 2: Вывести на консоль все методы класса, включая все родительские методы (включая приватные)");
    System.out.println(ReflectionUtils.allMethodsFormated(ExampleClass.class));

    System.out.println("\nTask 3: Вывести все геттеры класса");
    System.out.println(ReflectionUtils.allGetersFormated(ExampleClass.class));

    System.out.println("\nTask 4: Проверить что все String константы имеют значение = их имени");
    System.out.println(ReflectionUtils.isAllStringConstantsContentEqualsToName(ExampleClass.class));

    System.out.println("\nTask 5: Реализовать кэширующий прокси(первое число вычисляется, второе берется из кеша)");
    Calculator calculator = CachedInvocationHandler.newInstance(new SlowCalculator());
    System.out.println(calculator.calc(7));
    System.out.println(calculator.calc(7));

    System.out.println("\nTask 6: Создать свою аннотацию Metric. Реализовать proxy класс PerformanceProxy");
    CachedInvocationHandler.evict();
    calculator = PerformanceProxy.newInstance(new SlowCalculator());
    System.out.println(calculator.calc(5));

    System.out.println("\nTask 7: Реализовать BeanUtils");
    var exampleClass1 = new ExampleClass();
    exampleClass1.setField1("1");
    exampleClass1.setField2(1);
    exampleClass1.setField3(1);

    var exampleClass2 = new ExampleClass();
    exampleClass2.setField1("2");
    exampleClass2.setField2(2);
    exampleClass2.setField3(2);

    BeanUtils.assign(exampleClass2, exampleClass1);
    System.out.println(exampleClass2);
    
  }
}