package org.example;

@FunctionalInterface
public interface Singable {

  void sing(String song);

  default void writeSong(){

  }

}
