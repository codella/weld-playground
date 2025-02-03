package dk.codella.weld.interceptor;

import com.google.common.flogger.FluentLogger;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Car {

  private static final FluentLogger logger = FluentLogger.forEnclosingClass();

  @Honk
  public void drive() {
    logger.atInfo().log("wrooom!");
  }
}
