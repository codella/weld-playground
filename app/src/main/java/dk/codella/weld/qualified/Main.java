package dk.codella.weld.qualified;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Main {

  public static void main(String[] args) {
    WeldContainer container = new Weld()
        .disableDiscovery()
        .addBeanClass(Entry.class)
        .addBeanClass(Chiquita.class)
        .addBeanClass(Melinda.class)
        .addServices()
        .initialize();

    container.select(Entry.class).get().perform();
    container.shutdown();
  }

}
