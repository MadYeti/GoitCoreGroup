package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws Exception{

    //InputStream
//    File file = new File("src/main/resources/pyshellext.amd64.dll");
//    FileInputStream fileInputStream = new FileInputStream(file);
//    byte[] bytes = fileInputStream.readAllBytes();
//    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
//
//    while(byteArrayInputStream.available() > 0){
//      byte read = (byte)byteArrayInputStream.read();
//      System.out.println(read);
//    }
//    byteArrayInputStream.close();
//    System.out.println(byteArrayInputStream.read());


    //OutputStream

//    ByteArrayOutputStream baos = new ByteArrayOutputStream(32);
//    for (int i = 0; i < 10; i++){
//      baos.write(i);
//    }
//    baos.flush();
//    System.out.println(Arrays.toString(baos.toByteArray()));
//    baos.close();
//    baos.write(45);
//    System.out.println(Arrays.toString(baos.toByteArray()));

    //Reader

//    char[] chars = {'J', 'a', 'v', 'a'};
//
//    CharArrayReader reader = new CharArrayReader(chars);
//    char[] buffer = new char[8];
//
//    reader.read(buffer, 0 ,buffer.length);
//    for (Character c: buffer) {
//      System.out.println(c);
//    }

//    int nextChar = -1;
//    while((nextChar = reader.read()) != -1){
//      char c = (char) nextChar;
//      System.out.println(c);
//    }


    //Writer

//    CharArrayWriter charArrayWriter = new CharArrayWriter();
//
//    charArrayWriter.append("char array");
//
//    char[] result = charArrayWriter.toCharArray();
//
//    System.out.println(Arrays.toString(result));


    //FileOutputStream

//    String text = "Hello from Output Stream";
//    try(FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/test.txt")){
//      byte[] bytes = text.getBytes();
//      fileOutputStream.write(bytes, 0 , bytes.length);
//      fileOutputStream.flush();
//    }

    //FileWriter

//    String text = "Hello from Output Stream";
//    FileWriter fileWriter = new FileWriter("src/main/resources/test.txt");
//    fileWriter.append(text);
//    fileWriter.flush();


    //FileInputStream

//    try(FileInputStream fileInputStream = new FileInputStream("src/main/resources/download.jpg")) {
//      System.out.println("File size is bytes: " + fileInputStream.available());
//      byte[] buffer = new byte[fileInputStream.available()];
//      fileInputStream.read(buffer);
//      File file = new File("src/main/resources/download2.jpg");
//      FileOutputStream fileOutputStream = new FileOutputStream(file);
//      fileOutputStream.write(buffer);
//      fileOutputStream.flush();
//      for (int i = 0; i < buffer.length; i++) {
//        System.out.print(buffer[i] + " ");
//      }
//    }

    //FileReader

//    try (FileReader reader = new FileReader("src/main/resources/test.txt")) {
//      int c;
//      while ((c = reader.read()) != -1) {
//        System.out.print((char) c);
//      }
//    }

  }

  //Serialization

//    try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/resources/person.dat"))) {
//      Person p = new Person("Sam", 33, 178, true);
//      oos.writeObject(p);
//    } catch(Exception ex) {
//      System.out.println(ex.getMessage());
//    }

//    try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/resources/person.dat"))) {
//      Person p = (Person) ois.readObject();
//      System.out.printf(p.toString());
//    } catch(Exception ex) {
//      ex.printStackTrace();
//    }

//    Person person = new Person("Jhon", 23, 180, false);
//    ObjectMapper objectMapper = new ObjectMapper();
//    System.out.println(objectMapper.writeValueAsString(person));
//
//    String json = "{\n" +
//        "  \"name\": \"Bill\",\n" +
//        "  \"age\": 30,\n" +
//        "  \"married\": true,\n" +
//        "  \"height\": 1.78\n" +
//        "}";

//    Person person1 = objectMapper.readValue(json, Person.class);
//    System.out.println(person1);
}