package com.consol.service;

public class CallClassWithAnnotations {

    private ClassWithAnnotations classWithAnnotations;

    @Secured
    public void securedWayToCall() {
        classWithAnnotations.getMyPayload();
    }


    public void notSecuredWay() {
        classWithAnnotations.getMyPayload();
    }
}
