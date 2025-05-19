package dk.codella.weld.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Main {

  public static void main(String[] args) {
    WeldContainer container = new Weld().disableDiscovery()
        .addBeanClass(Bean.class)
        .initialize();

    Bean bean = container.select(Bean.class).get();
    bean.perform();
  }

  private static class Bean {

    public void perform() {
      System.out.println("Bean has performed");
    }

    @PostConstruct
    public void postConstruct() {
      System.out.println("postConstruct() invoked");
    }

    @PreDestroy
    public void preDestroy() {
      System.out.println("preDestroy() invoked");
    }
  }
}
