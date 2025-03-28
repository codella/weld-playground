package dk.codella.weld.alternative;

import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;

@ApplicationScoped
@Alternative
// If both FirstAlternative and SecondAlternative are activated, then they need to specify
// a priority. As a side effect, specifying @Priority will also automatically activate the alternative.
//@Priority(10)
public class SecondAlternative implements Entity {
  @Override
  public String name() {
    return "Second alternative";
  }
}
