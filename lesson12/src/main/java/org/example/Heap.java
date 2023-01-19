package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.State.TIMED_WAITING;

public class Heap {

  public void threadState() throws InterruptedException {
    MyThread myThread = new MyThread();
    myThread.setDaemon(false);
    System.out.println("MyThread state: " + myThread.getState());
    myThread.start();
    int i = 0;
    while (i < 100000) {
      if(myThread.getState() == TIMED_WAITING) {
        System.out.println("MyThread state: " + myThread.getState());
        break;
      }
      i++;
    }
    synchronized (myThread){
      myThread.notify();
      System.out.println("MyThread state: " + myThread.getState());
    }
    synchronized (Thread.currentThread()){
      Thread.currentThread().wait(10000);
    }
    System.out.println("MyThread state: " + myThread.getState());


    //MyThread run method
//    System.out.println("MyThread state: " + this.getState());
//    System.out.println("MyThread is working");
//    synchronized (this) {
//      try {
//        this.wait(10000);
//      } catch (InterruptedException e) {
//        throw new RuntimeException(e);
//      }
//    }
//    System.out.println("MyThread continue to work after sleep");
  }


  public void sleepThreads() throws InterruptedException {
    Thread sleepThread = new Thread(() -> {
      while (true) {
        System.out.println("about to sleep");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    });

    sleepThread.setDaemon(true);
    sleepThread.start();
    sleepThread.join();

    System.out.println("Main Thread");
  }

  public void threadRaceCondition(){
    Number number = new Number(0);

    Thread thread = new Thread(() -> {
      for(int i = 0; i < 400000; i++) {
        number.incrementNumber();
        System.out.println("Number from first Thread " + number.getNumber());
      }
    });

    Thread thread1 = new Thread(() -> {
      for(int i = 0; i < 400000; i++) {
        number.incrementNumber();
        System.out.println("Number from second Thread " + number.getNumber());
      }
    });


    thread.start();
    thread1.start();
  }

  public void deadlock(){
    final String resource1 = "resource1";
    final String resource2 = "resource2";
    Thread t1 = new Thread(() -> {
      synchronized (resource1) {
        System.out.println("Thread 1: locked resource 1");
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        System.out.println("Thread 1: await for resource 2");
        synchronized (resource2) {
          System.out.println("Thread 1: locked resource 2");
        }
      }
    });

    Thread t2 = new Thread(() -> {
      synchronized (resource2) {
        System.out.println("Thread 2: locked resource 2");
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        System.out.println("Thread 2: await for resource 1");
        synchronized (resource1) {
          System.out.println("Thread 2: locked resource 1");
        }
      }
    });


    t1.start();
    t2.start();
  }

  public void semaphore() throws InterruptedException {
//    static ArrayList<Car> cars = new ArrayList<>();
//    static Semaphore semaphore = new Semaphore(2);
    //Main method
    for (int i = 0; i < 10; i++) {
      new Thread(new Car()).start();
      Thread.sleep(400);
    }
  }

  public void exchanger(){
//    static final Exchanger<Integer> EXCHANGER = new Exchanger<>();
    //Main main
    new Thread(new MoneyExchanger(300)).start();
    new Thread(new MoneyExchanger(900)).start();
  }

  public void executorService() throws InterruptedException {
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
    Future<String> future = executor.submit(callableTask);
    List<Future<String>> futures = executor.invokeAll(callableTasks);
    executor.shutdown();
    try {
      if (!executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
        executor.shutdownNow();
      }
    } catch (InterruptedException e) {
      executor.shutdownNow();
    }

//    System.out.println(future.get());
  }

  public void livelock(){

  }

}
