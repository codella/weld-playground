package dk.codella.weld.interceptor;

import com.google.common.flogger.FluentLogger;
import jakarta.enterprise.context.Dependent;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Honk
@Interceptor
@Dependent
public class HonkInterceptor {

  private static final FluentLogger logger = FluentLogger.forEnclosingClass();

  @AroundInvoke
  public Object honk(InvocationContext ctx) throws Exception {
    logger.atInfo().log("first hooonk!");
    var ret = ctx.proceed();
    logger.atInfo().log("second hooonk!");
    return ret;
  }
}
