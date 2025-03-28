package dk.codella.weld.alternative;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class Entry {

  private final Entity entity;

  @Inject
  public Entry(
      /* will inject the Entity alternative with the highest priority */
      Entity entity) {
    this.entity = entity;
  }

  public void perform() {
    System.out.println(entity.name());
  }

}
