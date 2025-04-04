package dk.codella.weld.transitive;

import jakarta.inject.Inject;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Main {

  public static void main(String[] args) {
    WeldContainer container = new Weld().disableDiscovery()
        // Adding the beans to the container, so we can
        // delegate to the container their instantiation
        .addBeanClass(TransitiveBean.class)
        .addBeanClass(Bean.class)
        .initialize();

    Bean bean = container.select(Bean.class).get();
    bean.perform();
  }

  private static class Bean {

    private final TransitiveBean transitiveBean;

    @Inject
    public Bean(TransitiveBean transitiveBean) {
      // The container will first create an instance of
      // TransitiveBean, and then pass (inject) it as
      // an argument to this constructor
      this.transitiveBean = transitiveBean;
    }

    public void perform() {
      transitiveBean.transitivePerform();
    }
  }

  private static class TransitiveBean {

    public void transitivePerform() {
      System.out.println("TransitiveBean has performed");
    }
  }
}
