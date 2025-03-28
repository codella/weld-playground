package dk.codella.weld.decorator;

import com.google.common.flogger.FluentLogger;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Main {

  private static final FluentLogger logger = FluentLogger.forEnclosingClass();

  public static void main(String[] args) {
    WeldContainer container = new Weld()
        .disableDiscovery()
        // We need to add a bean, otherwise Weld won't boostrap
        .addBeanClass(Bean.class)
        .initialize();

    container.shutdown();
  }

  @ApplicationScoped
  private class Bean {}
}
