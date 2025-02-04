package dk.codella.weld.extension;

import com.google.common.flogger.FluentLogger;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.enterprise.inject.spi.AfterBeanDiscovery;
import jakarta.enterprise.inject.spi.Extension;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Entry {

  private static final FluentLogger logger = FluentLogger.forEnclosingClass();

  public static void main(String[] args) {
    WeldContainer container = new Weld()
        .disableDiscovery()
        // We need to add a bean, otherwise Weld won't boostrap
        .addBeanClass(Bean.class)
        .addExtension(new AppExtension())
        .initialize();

    container.shutdown();
  }

  private static class AppExtension implements Extension {

    public void doSomething(@Observes AfterBeanDiscovery evt) {
      logger.atInfo().log("After bean discovery intercepted");
    }

  }

  @ApplicationScoped
  private class Bean {

  }
}
