package org.example;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

public class Main {
  public static void main(String[] args) {

    Singable singable = song -> {};

    singable.sing("song");

    Iterable<Object> objects = () -> null;

    Comparable comparable = o -> 0;

    Externalizable externalizable = new Externalizable() {
      @Override
      public void writeExternal(ObjectOutput out) throws IOException {

      }

      @Override
      public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

      }
    };

    Person person = new Person(30, "Jhon");

    Optional<Person> optionalPerson = Optional.of(person);

    optionalPerson.ifPresent(value -> System.out.println(value));
    optionalPerson.orElseGet(() -> new Person(12, "David"));

    String defaultName = optionalPerson.filter(per -> per.getAge() != 28)
        .map(per -> per.getName())
        .orElse("DefaultName");

    System.out.println(defaultName);
  }
}