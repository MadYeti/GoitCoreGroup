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
import java.io.OutputStream;
import java.util.Arrays;

public class SandBox {

  void inputStream() throws Exception{
    byte[] bytes = {1, 3, 5, 7, 9};
    File file = new File("src/main/resources/pyshellext.amd64.dll");
    FileInputStream fileInputStream = new FileInputStream(file);
//    byte[] bytes = fileInputStream.readAllBytes();
    InputStream bais = new ByteArrayInputStream(bytes);
//    byte[] buffer = new byte[32];
//    int i = bais.read(buffer, 0, buffer.length);

    while (bais.available() > 0) {
      byte currentByte = (byte) bais.read();
      System.out.println(currentByte);
    }

    bais.close();//Does nothing
    System.out.println((byte) bais.read());
  }

  void outputStream() throws Exception{
    ByteArrayOutputStream baos = new ByteArrayOutputStream(32);
    for(int i = 1; i < 10; i++) {
      baos.write(i);
    }
    baos.flush();
    System.out.println(Arrays.toString(baos.toByteArray()));
    baos.close();//Does nothing
    baos.write(44);
    System.out.println(Arrays.toString(baos.toByteArray()));
  }

  void reader() throws Exception{
    char[] chars = {'J', 'a', 'v', 'a'};

    CharArrayReader reader = new CharArrayReader(chars);
    char[] buffer = new char[8];

    reader.read(buffer, 0, buffer.length);
    for (Character c: buffer) {
      System.out.println(c);
    }

    int nextChar = -1;
    while((nextChar = reader.read()) != -1) {
      char c = (char) nextChar;
      System.out.println(c);
    }
    reader.close();
  }

  void writer()throws Exception{
    CharArrayWriter charArrayWriter = new CharArrayWriter();

    charArrayWriter.append("Java");

    char[] result = charArrayWriter.toCharArray();

    System.out.println(Arrays.toString(result));
  }

  void fileOutputStream(){
    String text = "Hello from Output Stream";
    try(FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/test.txt")) {
      byte[] buffer = text.getBytes();
      fileOutputStream.write(buffer, 0, buffer.length);
      fileOutputStream.flush();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  void fileWriter(){
    File file = new File("src/main/resources/test.txt");
    try (FileWriter writer = new FileWriter(file))
    {
      String text = "Hello, World!";
      writer.write(text);
      writer.flush();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  void fileInputStream(){
    try(FileInputStream fileInputStream = new FileInputStream("src/main/resources/download.jpg")) {
      System.out.println("File size is bytes: " + fileInputStream.available());
      byte[] buffer = new byte[fileInputStream.available()];
      fileInputStream.read(buffer);
      File file = new File("src/main/resources/download2.jpg");
      FileOutputStream fileOutputStream = new FileOutputStream(file);
      fileOutputStream.write(buffer);
      fileOutputStream.flush();
      for (int i = 0; i < buffer.length; i++) {
        System.out.print(buffer[i] + " ");
      }
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  void fileReader(){
    try (FileReader reader = new FileReader("src/main/resources/test.txt")) {
      int c;
      while ((c = reader.read()) != -1) {
        System.out.print((char) c);
      }
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  void serialization() throws Exception{
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("lesson10/src/main/resources/person.dat"));
    Person p = new Person("Sam", 33, 178, true);
    oos.writeObject(p);
    oos.close();
  }

  void deserialization() throws Exception{
    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("lesson10/src/main/resources/person.dat"));
    Person p = (Person) ois.readObject();
    System.out.println(p.toString());
  }

  void exSerializable() throws Exception{
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("lesson10/src/main/resources/person.dat"));
    Person person1 = new Person("Donald", 35, 200, true);
    person1.writeExternal(oos);
  }

  void exDeserializable() throws Exception{
    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("lesson10/src/main/resources/person.dat"));
    Person person2 = new Person();
    person2.readExternal(ois);
    System.out.println(person2);
  }

  void json() throws Exception{
    Person person = new Person("Jhon", 23, 180, false);
    ObjectMapper objectMapper = new ObjectMapper();
    System.out.println(objectMapper.writeValueAsString(person));

    String json = "{\n" +
        "  \"name\": \"Bill\",\n" +
        "  \"age\": 30,\n" +
        "  \"married\": true,\n" +
        "  \"height\": 1.78\n" +
        "}";

    Person person1 = objectMapper.readValue(json, Person.class);
    System.out.println(person1);
  }
}
