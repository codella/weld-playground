package dk.codella.weld.qualified;

import dk.codella.weld.qualified.qualifiers.Banana;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class Entry {

  private final Fruit fruit;

  @Inject
  /* will inject the bean qualified with @Banana */
  public Entry(@Banana Fruit fruit) {
    this.fruit = fruit;
  }

  public void perform() {
    System.out.println(fruit.chew());
  }

}
