package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;

public class Heap {

  public void get()throws Exception{
    URL url = new URL("");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
    int responseCode = connection.getResponseCode();
    System.out.println("GET response code: " + responseCode);
    if (responseCode == HttpURLConnection.HTTP_OK) {
      BufferedReader in =
          new BufferedReader(
              new InputStreamReader(connection.getInputStream()));
      String inputLine;
      StringBuffer response = new StringBuffer();
      while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
      }
      in.close();
      System.out.println(response);
    } else {
      System.out.println("GET request not worked");
    }
  }

  public void post()throws Exception{
    URL url = new URL("");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("POST");
    connection.setDoOutput(true);
    OutputStream os = connection.getOutputStream();
    os.write(Files.readAllBytes(new File("lesson13/src/main/resources/user.json").toPath()));
    os.flush();
    os.close();

    int responseCode = connection.getResponseCode();
    System.out.println("POST response code: " + responseCode);
    if (responseCode == HttpURLConnection.HTTP_CREATED) {
      BufferedReader in =
          new BufferedReader(
              new InputStreamReader(connection.getInputStream()));
      StringBuffer response = new StringBuffer();
      String inputLine;
      while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
      }
      in.close();
      System.out.println(response);
    } else {
      System.out.println("POST request not worked");
    }
  }

}
