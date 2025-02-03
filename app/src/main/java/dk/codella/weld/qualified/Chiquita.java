package dk.codella.weld.qualified;

import jakarta.enterprise.context.ApplicationScoped;
import dk.codella.weld.qualified.qualifiers.Banana;

@Banana
@ApplicationScoped
public class Chiquita implements Fruit {
  @Override
  public String chew() {
    return "....mpf...";
  }
}
