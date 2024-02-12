package ru.zubkoff;

public class Main {

  
  public static void main(String[] args) {
    System.out.println("Task 2: Вывести на консоль все методы класса, включая все родительские методы (включая приватные)");
    System.out.println(ReflectionUtils.allMethodsFormated(ExampleClass.class));

    System.out.println("Task 3: Вывести все геттеры класса");
    System.out.println(ReflectionUtils.allGetersFormated(ExampleClass.class));

  }
}