package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {
  private static final String TEST_URL = "https://jsonplaceholder.typicode.com/users/1/todos";

  public static void main(String[] args) throws Exception {

    //Task #3
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(TEST_URL))
        .GET()
        .build();

    HttpResponse<String> response =
        client.send(request, HttpResponse.BodyHandlers.ofString());

    ObjectMapper objectMapper = new ObjectMapper();

    //Deserialization from json to todos list
    List<Todo> todos = objectMapper.readValue(response.body(), new TypeReference<>() {});

    List<Todo> completedTodos = todos.stream()
        .filter(Todo::isCompleted)
        .toList();

    System.out.println(completedTodos);


    //Task #2
//    HttpClient client = HttpClient.newHttpClient();
////    HttpRequest request = HttpRequest.newBuilder()
////        .header("Content-Type", "application/json")
////        .uri(URI.create(TEST_URL))
////        .PUT(HttpRequest.BodyPublishers.ofFile(Paths.get("lesson13/src/main/resources/user.json")))
////        .build();
//    HttpRequest request = HttpRequest.newBuilder()
//        .uri(URI.create(TEST_URL))
//        .GET()
//        .build();
//
//    HttpResponse<String> response =
//        client.send(request, HttpResponse.BodyHandlers.ofString());
//
//    System.out.println(response.statusCode());
//
//    ObjectMapper objectMapper = new ObjectMapper();
//
//    //Deserialization response body to posts list
//    List<Post> posts = objectMapper.readValue(response.body(), new TypeReference<>() {});
//
//    posts.add(new Post(2, 1, "title", "body"));
//
//    Optional<Integer> max = posts.stream()
//        .map(Post::getId)
//        .max(Integer::compareTo);
//
//    String URL = "https://jsonplaceholder.typicode.com/posts/".concat(max.get().toString()).concat("/comments");
//
//    HttpRequest secondRequest = HttpRequest.newBuilder()
//        .uri(URI.create(URL))
//        .GET()
//        .build();
//
//    HttpResponse<String> secondResponse =
//        client.send(secondRequest, HttpResponse.BodyHandlers.ofString());
//
//    //Deserialization response body to comments list
//    List<Comment> comments = objectMapper.readValue(secondResponse.body(), new TypeReference<>() {});
//
//    List<String> strings = comments.stream()
//        .map(Comment::getBody)
//        .toList();
//
//    System.out.println(strings);
  }
}