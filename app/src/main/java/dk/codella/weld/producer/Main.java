package dk.codella.weld.producer;

import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Main {

  public static void main(String[] args) {
    WeldContainer container = new Weld().disableDiscovery()
        .addBeanClasses(BeanWithProducers.class)
        .initialize();

    External external = container.select(External.class).get();
    external.perform();
  }

  public static class BeanWithProducers {
    @Produces
    // Methods annotated with @Produces behave as
    // if they were annotated with @Inject
    public External produceExternal() {
      return new External();
    }

    public void disposeExternal(@Disposes External external) {
      external.dispose();
    }
  }

  public static class External {

    public void perform() {
      System.out.println("External has performed");
    }

    public void dispose() {
      System.out.println("External has been disposed");
    }
  }

}
