package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Main {


  public static void main(String[] args) throws Exception {

    ExecutorService executor = Executors.newFixedThreadPool(5);

    Runnable runnableTask = () -> {
      System.out.println("Runnable task");
      //TODO logic
    };

    Callable<String> callableTask = () -> {
      System.out.println("Callable task");
      //TODO logic
      return "Callable task result";
    };

    List<Callable<String>> callableTasks = new ArrayList<>();
    callableTasks.add(callableTask);
    callableTasks.add(callableTask);
    callableTasks.add(callableTask);

    executor.execute(runnableTask);
//    Future<String> future = executor.submit(callableTask);
    List<Future<String>> futures = executor.invokeAll(callableTasks);
//    executor.shutdown();
//    try {
//      if (!executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
//        executor.shutdownNow();
//      }
//    } catch (InterruptedException e) {
//      executor.shutdownNow();
//    }

//    System.out.println(future.get());
    futures.forEach(result -> {
      try {
        System.out.println(result.get());
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      } catch (ExecutionException e) {
        throw new RuntimeException(e);
      }
    });

  }


}