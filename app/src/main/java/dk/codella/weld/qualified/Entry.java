package dk.codella.weld.qualified;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Entry {

  public static void main(String[] args) {
    WeldContainer container = new Weld()
        .disableDiscovery()
        .addBeanClass(Business.class)
        .addBeanClass(Chiquita.class)
        .addBeanClass(Melinda.class)
        .initialize();

    container.select(Business.class).get().quack();
    container.shutdown();
  }

}
