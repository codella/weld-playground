package dk.codella.weld.qualified;

import com.google.common.flogger.FluentLogger;
import jakarta.enterprise.event.Observes;
import jakarta.enterprise.inject.spi.AfterBeanDiscovery;
import jakarta.enterprise.inject.spi.Extension;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Entry {

    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    public static void main(String[] args) {
        WeldContainer container =  new Weld()
                .disableDiscovery()
                .addBeanClass(Business.class)
                .addBeanClass(Chiquita.class)
                .addBeanClass(Melinda.class)
                .initialize();

        container.select(Business.class).get().quack();
        container.shutdown();
    }

    private static class AppExtension implements Extension {

        public void abdh(@Observes AfterBeanDiscovery evt) {
            logger.atInfo().log("After bean discovery intercepted");
        }

    }
}
