package dk.codella.weld.interceptor;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Honk
@Interceptor
public class HonkInterceptor {

  @AroundInvoke
  public void honk(InvocationContext ctx) {

  }
}
