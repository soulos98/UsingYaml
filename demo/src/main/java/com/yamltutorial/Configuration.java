package com.yamltutorial;

import java.util.ArrayList;
import java.util.List;

public class Configuration {
    private List<SystemParameterFactory> factories;

    Configuration(){
        factories = new ArrayList<SystemParameterFactory>();
    }

    public List<SystemParameterFactory> getFactories() {
        return factories;
    }

    public void setFactories(List<SystemParameterFactory> factories) {
        this.factories = factories;
    }
}

// The SystemParameterFactory class remains the same
