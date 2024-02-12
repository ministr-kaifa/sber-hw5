package ru.zubkoff;

public class Main {

  
  public static void main(String[] args) {
    System.out.println("\nTask 2: Вывести на консоль все методы класса, включая все родительские методы (включая приватные)");
    System.out.println(ReflectionUtils.allMethodsFormated(ExampleClass.class));

    System.out.println("\nTask 3: Вывести все геттеры класса");
    System.out.println(ReflectionUtils.allGetersFormated(ExampleClass.class));

    System.out.println("\nTask 3: Проверить что все String константы имеют значение = их имени");
    System.out.println(ReflectionUtils.isAllStringConstantsContentSameAsName(ExampleClass.class));

  }
}