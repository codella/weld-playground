package dk.codella.weld.interceptor;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Entry {

  public static void main(String[] args) {
    WeldContainer container = new Weld()
        .disableDiscovery()
        .addBeanClass(Car.class)
        .addBeanClass(HonkInterceptor.class)
        .addInterceptor(HonkInterceptor.class)
        /* Also viable: .enableInterceptors(HonkInterceptor.class, ...) */
        .initialize();

    container.select(Car.class).get().drive();
    container.shutdown();
  }
}

