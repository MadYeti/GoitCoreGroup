package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
  private static final String TEST_URL = "https://jsonplaceholder.typicode.com/users/3";

  public static void main(String[] args) throws Exception {

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(TEST_URL))
        .GET()
        .build();

    HttpResponse<String> response =
        client.send(request, HttpResponse.BodyHandlers.ofString());

    System.out.println(response.statusCode());


    URL url = new URL(TEST_URL);
    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
    httpURLConnection.setRequestMethod("POST");
    httpURLConnection.setDoOutput(true);
    OutputStream outputStream = httpURLConnection.getOutputStream();
    outputStream.write(Files.readAllBytes(new File("lesson13/src/main/resources/user.json").toPath()));
    outputStream.flush();
    System.out.println(httpURLConnection.getResponseCode());
    BufferedReader bf = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
    String line;
    while((line = bf.readLine()) != null){
      System.out.println(line);
    }

  }
}