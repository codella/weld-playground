package dk.codella.weld.alternative;

import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;

@ApplicationScoped
@Alternative
@Priority(10)
public class FirstAlternative implements Entity {
  @Override
  public String name() {
    return "First alternative";
  }
}
