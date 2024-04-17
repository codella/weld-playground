import com.google.common.flogger.FluentLogger;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.example.alternative.Entity;
import org.jboss.weld.environment.se.events.ContainerInitialized;

@ApplicationScoped
public class Entry {

    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    @Inject
    @ConfigProperty(name = "message")
    private String message;

    @Inject
    private Entity entity;

    public void start(@Observes ContainerInitialized event) {
        logger.atInfo().log(message);
        logger.atInfo().log("Entity says they are called %s", entity.name());
    }
}
