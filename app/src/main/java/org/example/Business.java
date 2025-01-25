package org.example;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.example.alternative.Entity;
import org.example.qualified.Fruit;
import org.example.qualified.qualifiers.Banana;

@ApplicationScoped
public class Business {

  private Entity entity;
  private Fruit fruit;

  @Inject
  public Business(
          /* will inject the Entity alternative with highest priority */
          Entity entity,
          @Banana Fruit fruit) {
    this.entity = entity;
    this.fruit = fruit;
  }

  public void quack() {
    System.out.println(entity.name());
    System.out.println(fruit.chew());
  }

}
