package dk.codella.weld.alternative;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Main {

  public static void main(String[] args) {
    WeldContainer container = new Weld()
        .disableDiscovery()
        // Alternatives need to be activated with addAlternative(), but they still
        // need to be registered with addBeanClass()
        .addAlternative(SecondAlternative.class)
        .addAlternative(FirstAlternative.class)
        // Alternatives need to be registered as beans, but won't activate by default
        .addBeanClass(SecondAlternative.class)
        .addBeanClass(FirstAlternative.class)
        .addBeanClass(Mainstream.class)
        .addBeanClass(Entry.class)
        .initialize();

    container.select(Entry.class).get().perform();
    container.shutdown();
  }
}
