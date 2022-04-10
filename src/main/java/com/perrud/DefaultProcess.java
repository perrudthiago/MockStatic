package com.perrud;

public class DefaultProcess {

    public String Process() {
        ServiceLocator serviceLocator = ServiceLocator.getInstance();
        String value = serviceLocator.lookup();

        System.out.println(String.format("Value: %s ", value));
        return value;
    }

}
