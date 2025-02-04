package dk.codella.weld.qualified;

import dk.codella.weld.qualified.qualifiers.Banana;
import jakarta.enterprise.context.ApplicationScoped;

@Banana
@ApplicationScoped
public class Chiquita implements Fruit {
  @Override
  public String chew() {
    return "....mpf...";
  }
}
