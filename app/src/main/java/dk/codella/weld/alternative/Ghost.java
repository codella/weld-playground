package dk.codella.weld.alternative;

import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;

@ApplicationScoped
@Alternative
@Priority(20)
public class Ghost implements Entity {
    @Override
    public String name() {
        return "Ole II";
    }
}
