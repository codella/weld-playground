package dk.codella.weld.start;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Main {

  public static void main(String[] args) {
    WeldContainer container = new Weld()
        // We will provide everything programmatically
        .disableDiscovery()
        // We add Bean to the container, so we can get the
        // container to instantiate it for us
        .addBeanClass(Bean.class)
        .initialize();

    // We ask the container to provide us with an instance
    // of Bean, so we can utilize it to perform.
    Bean bean = container.select(Bean.class).get();
    bean.perform();
  }

  private static class Bean {

    public void perform() {
      System.out.println("Bean has performed");
    }
  }
}
