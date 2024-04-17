package org.example.alternative;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;
import jakarta.enterprise.inject.Default;

@ApplicationScoped
public class Human implements Entity {
    @Override
    public String name() {
        return "John";
    }
}
