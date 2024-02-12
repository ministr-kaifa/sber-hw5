package ru.zubkoff;

class ParentExampleClass {
  private void privateParentMethod() { }
  protected void protectedParentMethod() { }
  public void publicParentMethod() { }
}

public class ExampleClass extends ParentExampleClass {
  private void privateChildMethod() { }
  protected void protectedChildMethod() { }
  public void publicChildMethod() { }
}
