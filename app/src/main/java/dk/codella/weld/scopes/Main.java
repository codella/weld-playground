package dk.codella.weld.scopes;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Main {

  public static void main(String[] args) {
    WeldContainer container = new Weld().disableDiscovery()
        .addBeanClasses(
            Bean.class,
            DependantBean.class,
            ApplicationScopedBean.class,
            SingletonBean.class
        )
        .initialize();

    // We ask the container to provide us with an instance
    // of Bean, so we can utilize it to perform.
    Bean bean = container.select(Bean.class).get();
    bean.perform();
  }

  private static class Bean {

    private final DependantBean dependantBean;
    private final ApplicationScopedBean applicationScopedBean;
    private final SingletonBean singletonBean;

    @Inject
    public Bean(
        DependantBean dependantBean,
        ApplicationScopedBean applicationScopedBean,
        SingletonBean singletonBean)
    {
      this.dependantBean = dependantBean;
      this.applicationScopedBean = applicationScopedBean;
      this.singletonBean = singletonBean;
    }

    public void perform() {
      System.out.println("Bean has performed");
    }
  }

  private static class DependantBean {}

  @ApplicationScoped
  private static class ApplicationScopedBean {}

  @Singleton
  private static class SingletonBean {}
}
