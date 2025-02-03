package dk.codella.weld.interceptor;

import com.google.common.flogger.FluentLogger;
import dk.codella.weld.alternative.Business;
import dk.codella.weld.alternative.Alien;
import dk.codella.weld.alternative.Ghost;
import dk.codella.weld.alternative.Human;
import dk.codella.weld.qualified.Chiquita;
import dk.codella.weld.qualified.Melinda;
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
                .addBeanClass(Alien.class)
                .addBeanClass(Ghost.class)
                .addBeanClass(Human.class)
                .addBeanClass(Chiquita.class)
                .addBeanClass(Melinda.class)
                .addExtension(new AppExtension())
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
