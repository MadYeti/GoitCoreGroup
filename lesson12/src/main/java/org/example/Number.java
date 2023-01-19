package org.example;

public class Number {

  private volatile int number;

  public Number(int number) {
    this.number = number;
  }

  public void incrementNumber(){
    this.number++;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }
}
