package com.begin.chapter3.ContextualizedSearchDependencies;

public class ContextoalizedDependencyLookupImpl implements ManagedComponent{

    private Dependency dependency;

    public void performLookup(Contrainer contrainer) {
        this.dependency = (Dependency) contrainer.getDependency("myDependency");
    }

    @Override
    public String toString() {
        return dependency.toString();
    }
}
