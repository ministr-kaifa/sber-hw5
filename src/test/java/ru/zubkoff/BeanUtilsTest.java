package ru.zubkoff;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.Test;

public class BeanUtilsTest {

  @Test
  public void sameClassAssignTest() {

    var exampleClass1 = new ExampleClass();
    exampleClass1.setField1("1");
    exampleClass1.setField2(1);
    exampleClass1.setField3(1);

    var exampleClass2 = new ExampleClass();
    exampleClass2.setField1("2");
    exampleClass2.setField2(2);
    exampleClass2.setField3(2);

    assertNotEquals(exampleClass1, exampleClass2);
    BeanUtils.assign(exampleClass2, exampleClass1);
    assertEquals(exampleClass1, exampleClass2);

  }

  class A {
    int field = 1;
    public int getField() {
      return field;
    }
    public void setField(int field) {
      this.field = field;
    }
  }

  class B {
    int field = 2;
    public int getField() {
      return field;
    }
    public void setField(int field) {
      this.field = field;
    }
  }

  @Test
  public void differentClassesAssignTest() {
    B b = new B();
    BeanUtils.assign(b, new A());
    assertEquals(1, b.getField());
  }

  
  class C {
    int field = 1;
    int differentTypeField = 10;
    public int getDifferentTypeField() {
      return differentTypeField;
    }
    public void setDifferentTypeField(int differentTypeField) {
      this.differentTypeField = differentTypeField;
    }
    public int getField() {
      return field;
    }
    public void setField(int field) {
      this.field = field;
    }
  }

  class D {
    int field = 2;
    String differentTypeField = "differentTypeField";
    public String getDifferentTypeField() {
      return differentTypeField;
    }
    public void setDifferentTypeField(String differentTypeField) {
      this.differentTypeField = differentTypeField;
    }
    public int getField() {
      return field;
    }
    public void setField(int field) {
      this.field = field;
    }
  }

  @Test
  public void fieldTypeMismatchTest() {
    D d = new D();
    assertDoesNotThrow(() -> BeanUtils.assign(d, new C()));
    assertEquals(1, d.getField());
  }


}
