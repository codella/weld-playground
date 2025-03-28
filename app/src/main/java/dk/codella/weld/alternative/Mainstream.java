package dk.codella.weld.alternative;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Mainstream implements Entity {
  @Override
  public String name() {
    return "Mainstream";
  }
}
