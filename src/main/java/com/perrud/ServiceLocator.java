package com.perrud;

public class ServiceLocator {


    private static ServiceLocator instance;

    private ServiceLocator(){}
    public static synchronized ServiceLocator getInstance() {

        if(instance == null) instance = new ServiceLocator();

        return instance;
    }

    public String lookup() {
        return "Real Class";
    }
}
