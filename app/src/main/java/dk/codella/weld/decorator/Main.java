package dk.codella.weld.decorator;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

// TODO: complete this example!
public class Main {

  public static void main(String[] args) {
    WeldContainer container = new Weld().disableDiscovery()
        // We need to add a bean, otherwise Weld won't boostrap
        .initialize();

    container.shutdown();
  }
}
