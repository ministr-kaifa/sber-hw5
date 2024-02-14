package ru.zubkoff;

import java.util.Objects;

class ParentExampleClass {
  private void privateParentMethod() { }
  protected void protectedParentMethod() { }
  public void publicParentMethod() { }
}

public class ExampleClass extends ParentExampleClass {

  private static final String MONDAY = "MONDAY";
  private static final String TUESDAY = "TUESDAY";
  private static final String WEDNESDAY = "WEDNESDAY";
  private static final String THURSDAY = "THURSDAY";
  private static final String FRIDAY = "FRIDAY";
  private static final String SATURDAY = "SATURDAY";
  private static final String SUNDAY = "SUNDAY";
  private static final int WEEK_LENGTH = 7;

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

  @Override
  public String toString() {
    return "ExampleClass [field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(field1, field2, field3);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ExampleClass other = (ExampleClass) obj;
    if (field1 == null) {
      if (other.field1 != null)
        return false;
    } else if (!field1.equals(other.field1)) {
      return false;
    }
    return field2 == other.field2 || field3 == other.field3;
  }

}
