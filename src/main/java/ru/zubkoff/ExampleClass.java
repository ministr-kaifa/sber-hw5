package ru.zubkoff;

class ParentExampleClass {
  private void privateParentMethod() { }
  protected void protectedParentMethod() { }
  public void publicParentMethod() { }
}

public class ExampleClass extends ParentExampleClass {

  private String field1;
  private int field2;
  private long field3;

  private void privateChildMethod() { }
  protected void protectedChildMethod() { }
  public void publicChildMethod() { }
  
  public String getField1() {
    return field1;
  }
  
  public void setField1(String field1) {
    this.field1 = field1;
  }
  
  public int getField2() {
    return field2;
  }
  
  public void setField2(int field2) {
    this.field2 = field2;
  }
  
  public long getField3() {
    return field3;
  }
  
  public void setField3(long field3) {
    this.field3 = field3;
  }

}
