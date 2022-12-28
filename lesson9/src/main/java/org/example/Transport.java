package org.example;

import java.util.List;

public abstract class Transport {

  public abstract void drive();

  public static void driveAllTransport(List<? extends Transport> transports) {
    for(Transport transport : transports) {
      transport.drive();
    }
  }

}
