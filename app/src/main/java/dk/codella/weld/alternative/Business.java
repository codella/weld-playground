package dk.codella.weld.alternative;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class Business {

  private Entity entity;

  @Inject
  public Business(
      /* will inject the Entity alternative with the highest priority */
      Entity entity) {
    this.entity = entity;
  }

  public void quack() {
    System.out.println(entity.name());
  }

}
