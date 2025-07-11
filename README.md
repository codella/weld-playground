# Weld Playground

A collection of examples demonstrating various features of Weld SE (CDI implementation) for Java applications. This repository serves as a learning resource for understanding different aspects of Contexts and Dependency Injection (CDI) using Weld's standalone environment.

## Examples

### Alternative (`alternative/Main.java`)
Demonstrates CDI alternatives functionality, showing how to register and activate alternative implementations. The example shows how alternatives need to be both registered as beans and explicitly activated, with precedence rules when multiple alternatives are present.

### Decorator (`decorator/Main.java`)
*Note: This example is incomplete (TODO)*
Placeholder for demonstrating CDI decorator pattern functionality.

### Extension (`extension/Main.java`)
Shows how to create and use CDI extensions to observe and modify the container's behavior during bootstrap. The example demonstrates intercepting the `AfterBeanDiscovery` lifecycle event.

### Interceptor (`interceptor/Main.java`)
Comprehensive example of CDI interceptor functionality. Demonstrates how to create custom interceptor bindings, register interceptors, and apply cross-cutting concerns to bean methods. Shows the `@Honk` custom interceptor applied to a `Car` bean's `drive()` method.

### Lifecycle (`lifecycle/Main.java`)
Demonstrates bean lifecycle management with `@PostConstruct` and `@PreDestroy` annotations. Shows how these lifecycle callbacks are automatically invoked by the container during bean creation and destruction.

### Producer (`producer/Main.java`)
Shows CDI producer methods and disposer methods. Demonstrates how to create beans for external classes that cannot be directly managed by CDI, and how to properly dispose of them using `@Disposes`.

### Qualified (`qualified/Main.java`)
Demonstrates CDI qualifiers for distinguishing between different implementations of the same type. Shows how to use custom qualifiers to inject specific bean implementations.

### Scopes (`scopes/Main.java`)
Illustrates different CDI scopes including `@Dependent` (default), `@ApplicationScoped`, and `@Singleton`. Shows how scope affects bean lifecycle and instance management.

### Start (`start/Main.java`)
Basic "Hello World" example showing the fundamentals of setting up a Weld container, registering beans, and retrieving instances. Good starting point for understanding CDI basics.

### Transitive (`transitive/Main.java`)
Demonstrates dependency injection with constructor injection. Shows how the container automatically resolves and injects transitive dependencies when creating bean instances.

## Building and Running

This project uses Gradle for build management. To run any of the examples:

```bash
./gradlew run
```

Each example can be run independently by executing the respective `Main` class.