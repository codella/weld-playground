package dk.codella.weld.qualified;

import dk.codella.weld.qualified.qualifiers.Banana;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class Business {

  private final Fruit fruit;

  @Inject
  public Business(
          /* will inject the bean qualified with @Banana */
          @Banana Fruit fruit) {
    this.fruit = fruit;
  }

  public void quack() {
    System.out.println(fruit.chew());
  }

}
