package org.example;

import org.example.homework.Day;
import org.example.homework.MyArrayList;
import org.example.homework.MyHashMap;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
  public static void main(String[] args) {

    ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
    arrayDeque.add(2);
    arrayDeque.add(4);
    arrayDeque.add(5);
    arrayDeque.add(7);
    arrayDeque.add(8);
    System.out.println(arrayDeque);
    System.out.println(arrayDeque.peek());
    System.out.println(arrayDeque);
    System.out.println(arrayDeque.poll());
    System.out.println(arrayDeque);

//    Map<Character, Character> bracketsType = Map.of(')', '(', ']', '[', '}', '{');
//    Deque<Integer> openBracketsIndex = new ArrayDeque<>();
//    Deque<Character> stack = new ArrayDeque<>();
//    Scanner scanner = new Scanner(System.in);
//    String lineToParse = scanner.nextLine();
//    for(int i = 0; i < lineToParse.length(); i++){
//      if(bracketsType.containsKey(lineToParse.charAt(i))){
//        if(stack.isEmpty() || !stack.pop().equals(bracketsType.get(lineToParse.charAt(i)))){
//          System.out.println(i + 1);
//          return;
//        }
//        openBracketsIndex.pop();
//      }else if(bracketsType.containsValue(lineToParse.charAt(i))){
//        stack.push(lineToParse.charAt(i));
//        openBracketsIndex.push(i + 1);
//      }
//    }
//    if(!stack.isEmpty()){
//      System.out.println(openBracketsIndex.pop());
//      return;
//    }
//    scanner.close();
//    System.out.println("Success");



//    StringToIntFunction function = new StringToIntFunction("10");
//    System.out.println(function.apply(function.getNumber()));
//
//    KeyValuePair<String, BigDecimal> pair = new KeyValuePair<>("", new BigDecimal("1"));
//
//    Transport.driveAllTransport(List.of(new Car(), new Bike()));

//    List<Integer> integerList = List.of(1, 3, 5, 6, 8);
//    List<Long> longList = List.of(1L, 3L, 5L, 6L, 8L);
//    List<String> stringList = List.of("asd", "erwer", "234243", "asdasd", "zbcbx");
//    List<Car> carList = List.of(new Car(), new Car());
//
//    printList(integerList);
//    printList(longList);
//    printList(stringList);
//    printList(carList);


//    List<Integer> list = new LinkedList<>();
//    list.add(1);
//    list.add(2);
//    list.add(3);
//    System.out.println(list);


    //ArrayList
//    MyArrayList<String> stringList = new MyArrayList<>(new String[10]);
//    stringList.add("23");
//    stringList.add("56");
//    stringList.add("45");
//    System.out.println(stringList);
//    System.out.println(stringList.contains("56"));
//    System.out.println(stringList.remove("56"));
//    System.out.println(stringList);
//    System.out.println(stringList.contains("56"));

    //HashMap
//    MyHashMap<Integer, String> map = new MyHashMap<>(new MyHashMap.Node[16]);
//    System.out.println(map.size());
//    map.put(1, "Kyiv");
//    map.put(2, "Warsaw");
//    map.put(3, "London");
//    map.put(4, "Madrid");
//    map.put(5, "Paris");
//    map.put(6, "Rome");
//    map.put(7, "Berlin");
//    map.put(8, "Prague");
//    map.put(9, "Oslo");
//    map.put(10, "Helsinki");
//    map.put(11, "Lisbon");
//    map.put(12, "Tokyo");
//    map.put(13, "Dublin");
//    map.put(14, "Tbilisi");
//    map.put(15, "Sofia");
//    map.put(16, "Amsterdam");
//    System.out.println(map);
//    map.remove(12);
//    System.out.println(map);
//    System.out.println(map.get(12));

  }

  public static  <E> void printList(List<E> data) {
    for(E item: data) {
      System.out.print(item + " ");
    }
    System.out.println();
  }
}