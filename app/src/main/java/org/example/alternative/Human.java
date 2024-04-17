package org.example.alternative;

import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;

@ApplicationScoped
@Alternative
@Priority(500)
public class Human implements Entity {
    @Override
    public String name() {
        return "John";
    }
}
