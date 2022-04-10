package com.paytrue;

import com.perrud.ServiceLocator;

public class ServiceLocatorMock {

    private static ServiceLocatorMock instance;

    private ServiceLocatorMock(){}
    public static synchronized ServiceLocatorMock getInstance() {

        if(instance == null) instance = new ServiceLocatorMock();

        return instance;
    }

    public String lookup() {
        return "Mock Class";
    }
}
