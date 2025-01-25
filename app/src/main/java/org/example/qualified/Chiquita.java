package org.example.qualified;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.qualified.qualifiers.Banana;

@Banana
@ApplicationScoped
public class Chiquita implements Fruit {
  @Override
  public String chew() {
    return "....mpf...";
  }
}
