package org.example.qualified;

import jakarta.enterprise.context.ApplicationScoped;

@org.example.qualified.qualifiers.Apple
@ApplicationScoped
public class Melinda implements Fruit {
  @Override
  public String chew() {
    return "CRUNCH!";
  }
}
