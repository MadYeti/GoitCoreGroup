package org.example;

public class MoneyExchanger implements Runnable{

  int money;

  public MoneyExchanger(int money) {
    this.money = money;
  }

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " Setting up connection to bank");
    try {
      Thread.sleep((int) (Math.random() * 20000));
      System.out.println(Thread.currentThread().getName() + " Connected to bank. Waiting to other connections");
//      Main.EXCHANGER.exchange(money);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println(Thread.currentThread().getName() + " Successfully exchanged money");
  }

}
