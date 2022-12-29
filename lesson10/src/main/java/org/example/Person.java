package org.example;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serial;
import java.io.Serializable;

@Data
public class Person implements Serializable, Externalizable {

  @Serial
  private static final long serialVersionUID = 1;

  private String name;
  private int age;
  private transient double height;
  @JsonIgnore
  private transient boolean married;

  public Person() {
  }

  public Person(String name, int age, double height, boolean married) {
    this.name = name;
    this.age = age;
    this.height = height;
    this.married = married;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public boolean isMarried() {
    return married;
  }

  public void setMarried(boolean married) {
    this.married = married;
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", height=" + height +
        ", married=" + married +
        '}';
  }

  @Override
  public void writeExternal(ObjectOutput out) throws IOException {
    out.writeUTF(name);
    out.writeInt(age);
    out.writeDouble(height);
    out.writeBoolean(married);
    out.flush();
  }

  @Override
  public void readExternal(ObjectInput in) throws IOException {
    this.setName(in.readUTF());
    this.setAge(in.readInt());
    this.setHeight(in.readDouble());
    this.setMarried(in.readBoolean());
  }
}
