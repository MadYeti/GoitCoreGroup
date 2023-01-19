package org.example;

public class Car implements Runnable{

  @Override
  public void run() {
//    try {
//      System.out.println(Thread.currentThread().getName() + " Trying to find the parking lot");
//      Main.semaphore.acquire();
//      synchronized (Main.cars) {
//        System.out.println(Thread.currentThread().getName() + " Parking");
//        Main.cars.add(this);
//        System.out.println("Parking place : " + Main.cars);
//      }
//        Thread.sleep((int) (Math.random() * 10000));
//      synchronized (Main.cars) {
//        System.out.println(Thread.currentThread().getName() + " Left the parking lot");
//        Main.cars.remove(this);
//        System.out.println("Parking place : " + Main.cars);
//      }
//      Main.semaphore.release();
//    }catch (Exception e){
//      e.printStackTrace();
//    }
  }

}
