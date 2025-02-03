package dk.codella.weld.qualified;

import dk.codella.weld.qualified.qualifiers.Apple;
import jakarta.enterprise.context.ApplicationScoped;

@Apple
@ApplicationScoped
public class Melinda implements Fruit {
  @Override
  public String chew() {
    return "CRUNCH!";
  }
}
