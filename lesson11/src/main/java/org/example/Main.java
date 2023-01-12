package org.example;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class Main {

  static int counter = 0;
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


    //Stream API
    List<Integer> list = asList(1, 2, 4, 7, 5, 2, 9, 0, 10, 12, 14, 6, 4, 1, 1, 3);

    Supplier<Stream<String>> streamSupplier =
        () -> Stream.of("d2", "a2", "b1", "b3", "c")
            .filter(s -> s.startsWith("a"));

    streamSupplier.get().anyMatch(s -> true);   // ok
    streamSupplier.get().noneMatch(s -> true);  // ok

    Map<Integer, Integer> collect = list.stream()
        .collect(Collectors.toMap(number -> number, Function.identity(), (a, b) -> b, TreeMap::new));
    System.out.println(collect);

    HashMap<String, String> stringHashMap = new HashMap<>(2);
    stringHashMap.put("1", "1");
    stringHashMap.put("2", "1");
    stringHashMap.put("3", "1");
    stringHashMap.put("4", "1");
    System.out.println(stringHashMap);

  }
}